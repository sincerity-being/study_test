package com.study.algorithm.shangguigu.review.algori.graph.shortway.dijkstra;

import com.study.algorithm.shangguigu.review.algori.graph.Graph;
/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-06 10:46
 * @describe
 */
public class Main {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        // 表示不可以连接
        final int N = 65535;
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        //创建 Graph对象
        Graph graph = new Graph(vertex, matrix);

        //测试, 看看图的邻接矩阵是否ok
        graph.showGraph();
        //测试迪杰斯特拉算法
        //C --- 2  G-6
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);
        dijkstraAlgorithm.dsj(2);
        dijkstraAlgorithm.showDijkstra();


    }
}
