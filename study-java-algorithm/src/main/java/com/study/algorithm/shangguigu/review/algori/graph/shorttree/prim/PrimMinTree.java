package com.study.algorithm.shangguigu.review.algori.graph.shorttree.prim;

import com.study.algorithm.shangguigu.review.algori.graph.Graph;

import java.util.Arrays;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-24 10:46
 * @describe 创建最小生成树->村庄的图
 */
public class PrimMinTree {

    //创建图的邻接矩阵
    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(Graph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for(i = 0; i < verxs; i++) {//顶点
            graph.getVertex()[i] = data[i];
            for(j = 0; j < verxs; j++) {
                graph.getMatrix()[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(Graph graph) {
        for(int[] link: graph.getMatrix()) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树
    /**
     *
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
    public void prim(Graph graph, int v) {
        //visited[] 标记结点(顶点)是否被访问过
        int[] visited = new int[graph.getVerxs()];
        //visited[] 默认元素的值都是0, 表示没有访问过
//		for(int i =0; i <graph.verxs; i++) {
//			visited[i] = 0;
//		}

        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        int minWeight = 10000;
        //因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
        for(int k = 1; k < graph.getVerxs(); k++) {
            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            // i结点表示被访问过的结点
            for(int i = 0; i < graph.getVerxs(); i++) {
                //j结点表示还没有访问过的结点
                for(int j = 0; j< graph.getVerxs();j++) {
                    if(visited[i] == 1 && visited[j] == 0 && graph.getMatrix()[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = graph.getMatrix()[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.getVertex()[h1] + "," + graph.getVertex()[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }

    }





}
