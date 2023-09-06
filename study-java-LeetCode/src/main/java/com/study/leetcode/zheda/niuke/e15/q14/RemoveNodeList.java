package com.study.leetcode.enterprise.zheda.niuke.e15.q14;

import com.study.leetcode.enterprise.zheda.niuke.domain.Node;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-08 17:50
 * @describe  有头节点
 * 算法要点 空间换时间
 */
public class RemoveNodeList {

    public  void removeFunc(Node h, int n){
        Node p = h, r;
        int[] arr = new int[n+1];
        int m;
        // 初始化 arr
        for(int i = 0; i < n+1; i++){
            arr[i] = 0;
        }

        while(p.getNext() != null){
            m = p.getNext().getData() > 0 ? p.getNext().getData() : -p.getNext().getData();
            // 该数字首次出现
            if(arr[m] == 0){
                arr[m] = 1;
                p = p.getNext();
            }else{
                // 删除
                r = p.getNext();
                p.setNext(r.getNext());
            }
        }
    }

}
