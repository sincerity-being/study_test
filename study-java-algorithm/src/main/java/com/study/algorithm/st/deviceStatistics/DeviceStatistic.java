package com.study.algorithm.st.deviceStatistics;

import java.util.Iterator;
import java.util.LinkedList;

public class DeviceStatistic {

    /**
     * 链接每一个区间实体
     */
    public LinkedList<Entity> useList = new LinkedList<>();
    public LinkedList<Entity> malfunctionList = new LinkedList<>();
    public LinkedList<Entity> otherList = new LinkedList<>();

    /**
     * 时间区间实体,
     * 每一个区间实体都不会产生交集
     */
    private static class Entity {
        public Entity(long start, long end) {
            this.start = start;
            this.end = end;
        }

        //开始时间
        long start;
        //结束时间
        long end;

        @Override
        public String toString() {
            return "Entity{" +
                    "start=" + start / 3600000 +
                    ", end=" + end / 3600000 +
                    '}';
        }
    }

    /**
     * 稼动率
     *
     * @param start
     * @param end
     * @return
     */
    public int getRate(long start, long end) {
        if (end <= start) return 0;
        long useTime = getSize(1, start, end);
        long malTime = getSize(2, start, end);
        long otherTime = getSize(3, start, end);
        return (int) ((useTime - malTime - otherTime) * 100 / useTime);
    }


    /**
     * 查询覆盖区间大小
     *
     * @return -1表示出错
     */
    public long getSize(int type, long start, long end) {
        if (end < start) return -1;
        if (end == start) return 0;
        if (type == 1) {
            return getCover(useList, start, end);
        } else if (type == 2) {
            return getCover(malfunctionList, start, end);
        } else if (type == 3) {
            return getCover(otherList, start, end);
        }
        return -1;
    }

    private long getCover(LinkedList<Entity> list, long start, long end) {
        long ans = 0L;
        for (Entity entity : list) {
            if (start <= entity.start) {
                if (end <= entity.end) {
                    ans += end - entity.start;
                } else {
                    ans += entity.end - entity.start;
                }
            }
            if (entity.start < start && start <= entity.end) {
                if (end <= entity.end) {
                    ans += end - start;
                } else {
                    ans += entity.end - start;
                }
            }
            if (end < entity.start)
                break;
        }
        return ans;
    }

    /**
     * 添加区间
     *
     * @param type  1使用时间<br/> 2故障时间 <br/>3 非故障时间
     * @param start 开始时间戳
     * @param end   结束时间戳
     * @return true表示添加成功, false表示发生冲突
     */
    public boolean addInterval(int type, long start, long end) {
        if (start >= end)
            return false;
        if (type == 1) {
            return merge(useList, start, end);
        } else if (type == 2) {
            //判断是否在useList的区间内
            if (!checkCover(start, end)) return false;
            //判断是否和otherList冲突
            if (checkCross(otherList, start, end)) return false;
            return merge(malfunctionList, start, end);
        } else if (type == 3) {
            //判断是否在useList的区间内
            if (!checkCover(start, end)) return false;
            //判断是否和otherList冲突
            if (checkCross(malfunctionList, start, end)) return false;
            return merge(otherList, start, end);
        } else {
            return false;
        }
    }

    /**
     * 判断是否相交
     */
    private boolean checkCross(LinkedList<Entity> list, long start, long end) {
        if (end < start) return false;
        for (Entity entity : list) {
            if (entity.start < end && end < entity.end)
                return true;
            if (entity.start < start && start < entity.end)
                return true;
            if (entity.end < start)
                return false;
        }
        return false;
    }


    /**
     * 判断是否覆盖
     */
    public boolean checkCover(long start, long end) {
        if (end < start)
            return false;
        for (Entity entity : useList) {
            if (entity.start <= start && end <= entity.end)
                return true;
            if (!(end < entity.start))
                return false;
        }
        return false;
    }


    private boolean merge(LinkedList<Entity> list, long start, long end) {

        Iterator<Entity> entityIterator = list.descendingIterator();
        Entity last = null;
        for (; entityIterator.hasNext(); ) {
            Entity current = entityIterator.next();
            if (current.end <= end) {
                if (current.end < start) {
                    Entity entity = new Entity(start, end);
                    list.add(entity);
                    return true;
                }
                current.end = end;
                end = -1;
                if (current.start <= start) {
                    return true;
                }
                current.start = start;
            }
            if (end == -1 && current.end <= start) {
                return true;
            }
            if (current.start <= start && start <= current.end) {
                if (last != null) {
                    last.start = current.start;
                    entityIterator.remove();
                    return true;
                }
            }
            if (start < current.start) {
                entityIterator.remove();
            } else {
                last = current;
            }
        }
        if (list.isEmpty()) {
            list.add(new Entity(start, end));
        }
        return true;
    }

}
