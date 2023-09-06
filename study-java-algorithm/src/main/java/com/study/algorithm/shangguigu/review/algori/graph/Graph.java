package com.study.algorithm.shangguigu.review.algori.graph;

import java.util.Arrays;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-06 10:40
 * @describe
 */
public class Graph {

    int verxs; //表示图的节点个数

    /**
     * 顶点数组
     */
    private char[] vertex;

    /**
     * 邻接矩阵
     */
    private int[][] matrix;

    public Graph(int verxs) {
        this.verxs = verxs;
        this.vertex = new char[verxs];
        this.matrix = new int[verxs][verxs];
    }

    // 构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    // 显示图
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    public char[] getVertex() {
        return vertex;
    }

    public void setVertex(char[] vertex) {
        this.vertex = vertex;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getVerxs() {
        return verxs;
    }

    public void setVerxs(int verxs) {
        this.verxs = verxs;
    }
}
