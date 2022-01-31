package com.study.basic.dataStructures.queue;

import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-02-25 10:50
 * @describe
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
       // 测试一把
       // 1. 创建一个队列
       ArrayQueue arrayQueue = new ArrayQueue(4);
       char userKey;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 进行控制台遍历
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            //接收一个字符
            userKey = scanner.next().charAt(0);
            switch (userKey){
                case 's' :
                    System.out.println("查看该对列的所有元素");
                    arrayQueue.showQueue();
                    break;
                case 'a' :
                    System.out.println("输入要添加的数:");
                    int element = scanner.nextInt();
                    int rea = arrayQueue.addQueue1(element);
                    System.out.printf("rear此时为%d\n",rea);
                    break;
                case 'g' :
                    try{
                        int[] result = arrayQueue.getQueue2();
                        System.out.printf("取出的数是%d,此时的front是%d\n",result[0],result[1]);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h' :
                    try{
                        int res = arrayQueue.searchHeadQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e' :
                    System.out.println("系统退出");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }

}

class ArrayQueue{
    /** 数组的 容量大小 */
    private final int maxSize;

    /** 数组的头指针 指向的是 对列中的队首的前一个元素*/
    private int front;

    /** 数组的尾指针 指向的是队列中的最后一个元素.*/
    private int rear;

    /** 实际存值的地方*/
    private final int[] array;


    /** 构造方法  初始化队列 */
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.rear = -1;
        this.front = - 1;
        array = new int[maxSize];
    }


    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        /*return (this.rear == -1 && this.front == -1 )
                || this.front >= maxSize;*/
        return  rear == front;
    }

    /**
     * 判断队列是否满了.
     * @return
     */
    public  boolean isFull(){
        return this.rear == maxSize-1;
    }

    public void addQueue(int element){
        if (isFull()){
            System.out.println("对列已满了,不能再往里面添加元素了.");
        }
        array[++rear] = element;
    }

    public int addQueue1(int element){
     if (isFull()){
         System.out.println("对列已满了..");
         return this.rear;
     }
     array[++rear] = element;
     return rear;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("对列已经空了");
        }
        return array[++front];
    }

    public int[] getQueue2(){
        if (isEmpty()){
            throw new RuntimeException("队列已经空了");
        }
        // 构建一个匿名数组
        return new int[]{array[++front],front};
    }

    /**
     * 查看 队列的头元素
     * @return 返回队列的头元素
     */
    public int searchHeadQueue(){
      if (isEmpty()){
          throw new RuntimeException("队列已经空了");
      }
      // 只是查看,所以 front 不会真的变化
        return array[front + 1];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列已经空了");
            return;
        }
        /*  for (int i = front+1; i <= rear; i++){
            System.out.printf("array[%d]=%d",i,array[i]);
        }*/
        for (int i = 0 ; i < maxSize; i++){
            System.out.printf("array[%d]=%d\n",i,array[i]);
        }
    }






}
