package com.study.leetcode.algorithm.st.linklist.sum;

import java.util.*;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-02-09 09:57
 * @describe 链表是 逆序排列
 *l1=[2,4,3],l2=[5,6,4]
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers_two {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //遍历链表的


        return null;
    }
    public static void main(String[] args) {
      Map<String,List<Integer>> map=  getIntegerListFromStr();
      List<Integer> l1List = map.get("l1");
      List<Integer> l2List = map.get("l2");
        // 由list构建 ListNode;
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        for (Integer n : l1List){
            Node node = new Node(n);
        }

    }

    private static void getIntListFromHasNextLine() {
        List<Integer> l1 = new ArrayList<>(10);
        List<Integer> l2 = new ArrayList<>(10);
        Scanner scanner = new Scanner(System.in);
        int record = 1;
        while(scanner.hasNextLine()){
           String str = scanner.nextLine();
           System.out.println("str=" + str);
           for(int i = 0; i < str.length(); i++){
               if (str.charAt(i) == '['){
                   for (int j = i + 1; j < str.length(); j++){
                       char c = str.charAt(j);
                       if (c == ']'){
                           record++;
                           break;
                       }
                       if ( c >= '0' && c <= '9'){
                           if (record == 1){
                               l1.add(Integer.valueOf(c+""));
                           }
                           if (record > 1){
                               l2.add(Integer.valueOf(c+""));
                           }
                       }
                   }
               }
           }
          if (str.isEmpty()){
              break;
          }
       }
        scanner.close();
        System.out.println("l1==" + l1);
        System.out.println("l2==" + l2);
    }

    private static Map<String,List<Integer>> getIntegerListFromStr() {
        Map<String,List<Integer>> map = new HashMap<>(16);
        Scanner scanner = new Scanner(System.in);
        String srcStr = scanner.nextLine();
        System.out.println("srcStr="+ srcStr);
        List<Integer> l1List = new ArrayList<>(10);
        List<Integer> l2List = new ArrayList<>(10);
        int record = 1;
        for (int i = 0; i < srcStr.length(); i++){
            if(srcStr.charAt(i) == '['){
                for (int j = i+1; j < srcStr.length(); j++){
                    if (srcStr.charAt(j) == ']'){
                        i = j;
                        record++;
                        break;
                    }
                    char c = srcStr.charAt(j);
                    if(c >='0' && c<='9'){
                        if (record == 1){
                            l1List.add(Integer.valueOf(String.valueOf(c)));
                        }
                        if (record == 2){
                            l2List.add(Integer.valueOf(String.valueOf(c)));
                        }
                    }
                }
            }
        }
        System.out.println("l1=" + l1List);
        System.out.println("l2=" + l2List);
        map.put("l1",l1List);
        map.put("l2",l2List);
        return map;
    }


}


class Node{

    int val;
    Node next;
    Node() { }
    Node(int val){
        this.val = val;
    }

    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

/**
 * 创建一个链表
 */
class ListNode{
    /** 头结点 */
    private Node node;


}
