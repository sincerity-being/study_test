package com.study.easyCoding.ebook.chapter07.treadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-13 15:58
 * @describe
 */
public class CsGameByThreadLocal {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 10;
    private static final Integer TOTAL_PLAYERS = 10;

    private static  final ThreadLocalRandom RANDOM =  ThreadLocalRandom.current();

    //初始化子弹数
    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<>(){
        @Override
        protected  Integer initialValue(){
            return BULLET_NUMBER;
        }
    };

    // 初始化杀敌数
    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL = new ThreadLocal<>(){
      @Override
      protected Integer initialValue(){
          return KILLED_ENEMIES;
      }
    };

    //初始化自己的命数
    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL = new ThreadLocal<>(){
        @Override
        protected Integer initialValue(){
            return LIFE_VALUE;
        }
    };

    // 定义每位队员
    private static class Player extends Thread{

        @Override
        public void run(){
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS / 2);
            Integer lifeValue = LIFE_VALUE_THREADLOCAL.get() - RANDOM.nextInt(LIFE_VALUE);

            System.out.println(getName() + ", BULLET_NUMBER is" + bullets );
            System.out.println(getName() + ", TOTAL_PLAYERS is" + killEnemies);
            System.out.println(getName() + ", LIFE_VALUE is" + lifeValue);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }


}
