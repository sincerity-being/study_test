package com.study.algorithm.shangguigu.review.algori.graph.shortway.floyd;

import com.study.algorithm.shangguigu.review.algori.graph.Graph;

import java.util.Arrays;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-06 19:04
 * @describe
 */
public class FloydAlgorithm {

    // 保存到达目标顶点的前驱顶点
    private int[][] pre;

    private Graph graph;

    //弗洛伊德算法, 比较容易理解，而且容易实现
    public void floyd() {
        int[][] dis = graph.getMatrix();
        int len = 0; //变量保存距离
        //对中间顶点遍历， k 就是中间顶点的下标 [A, B, C, D, E, F, G]
        for(int k = 0; k < dis.length; k++) { //
            //从i顶点开始出发 [A, B, C, D, E, F, G]
            for(int i = 0; i < dis.length; i++) {
                //到达j顶点 // [A, B, C, D, E, F, G]
                for(int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];// => 求出从i 顶点出发，经过 k中间顶点，到达 j 顶点距离
                    if(len < dis[i][j]) {//如果len小于 dis[i][j]
                        dis[i][j] = len;//更新距离
                        pre[i][j] = pre[k][j];//更新前驱顶点
                    }
                }
            }
        }
    }

    public FloydAlgorithm(Graph graph) {
        int length = graph.getVertex().length;
        this.pre = new int[length][length];
        // 对pre数组初始化, 注意存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
        this.graph = graph;
    }

    // 显示pre数组和dis数组
    public void show() {
        int[][] dis = graph.getMatrix();
        //为了显示便于阅读，我们优化一下输出
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        for (int k = 0; k < dis.length; k++) {
            // 先将pre数组输出的一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            // 输出dis数组的一行数据
            for (int i = 0; i < dis.length; i++) {
                System.out.print("("+vertex[k]+"到"+vertex[i]+"的最短路径是" + dis[k][i] + ") ");
            }
            System.out.println();
            System.out.println();
        }

    }


}
