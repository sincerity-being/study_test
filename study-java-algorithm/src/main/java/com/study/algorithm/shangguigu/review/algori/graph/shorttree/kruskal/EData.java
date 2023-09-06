package com.study.algorithm.shangguigu.review.algori.graph.shorttree.kruskal;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-24 11:32
 * @describe 创建一个类EData ，它的对象实例就表示一条边
 */
public class EData {

    //边的一个点
    char start;
    //边的另外一个点
    char end;
    //边的权值
    int weight;
    //构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //重写toString, 便于输出边信息
    @Override
    public String toString() {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }

}
