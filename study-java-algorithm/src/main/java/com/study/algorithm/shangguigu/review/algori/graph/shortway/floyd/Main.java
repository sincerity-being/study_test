package com.study.algorithm.shangguigu.review.algori.graph.shortway.floyd;

import com.study.algorithm.shangguigu.review.algori.graph.Graph;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-06 19:09
 * @describe
 */
public class Main {

    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        //创建 Graph 对象
        Graph graph = new Graph(vertex,  matrix);
        //调用弗洛伊德算法
        FloydAlgorithm floydAlgorithm = new FloydAlgorithm(graph);
        floydAlgorithm.floyd();
        floydAlgorithm.show();

    }
}
