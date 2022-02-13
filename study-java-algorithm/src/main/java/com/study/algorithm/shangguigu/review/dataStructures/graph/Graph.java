/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */
package com.study.algorithm.shangguigu.review.dataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 注释..
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class Graph {

    // 节点
    private List<String> verNodeList;

    // 边的条数
    private int edgeNum ;

    // 图
    private int[][] graphArrays;

    // 该结点是否被访问过
    private boolean[] isVisited;

    public Graph(int n){
        verNodeList = new ArrayList<>(n);
        isVisited = new boolean[n];
        edgeNum = 0;
        graphArrays = new int[n][n];
      //  isVisited = new boolean[n];
    }

    // 1) 添加 节点
    public void insertNode(String s){
        verNodeList.add(s);
    }

    // 2) 添加 边
    public void insertEdge(int v1, int v2, int weight){
        graphArrays[v1][v2] = weight;
        graphArrays[v2][v1] = weight;
        edgeNum ++;
    }

    // 获取边数
    public int  getGraphEdges(){
        return edgeNum;
    }

    public int getNodeSize(){
        return verNodeList.size();
    }

    /**
     *   返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
     */
    public String getValueByIndex(int i) {
        return verNodeList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return graphArrays[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {
        for(int[] link : graphArrays) {
            System.err.println(Arrays.toString(link));
        }
    }

    // 获取某个节点的邻接节点
    public int getFirstNeighbor(int i){
        for (int j = 0 ; j < getNodeSize(); j++){
            if(graphArrays[i][j] > 0){
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2){
        for(int j = v2 + 1; j < getNodeSize(); j++){
            if (graphArrays[v1][j] >0){
                return j;
            }
        }
        return -1;
    }


    // 错误的 while 和递归是要结合的  递归和while循环是相互区别和联系的.
   private void dfs(int i){
        // 输出第一个节点
       System.out.print(getValueByIndex(i) +  ">=");
       isVisited[i] = true;
       int w = getFirstNeighbor(i);
       if (w != -1){
           if (!isVisited[w]){
               dfs(w);
           }
       }else{
         w = getNextNeighbor(i, w);
         if (w != -1){
             if (!isVisited[w]){
                 dfs(w);
             }
         }
       }

   }



    private void dfs(boolean[] isVisited, int i){
        // 输出第一个节点
        System.out.print(getValueByIndex(i) +  ">=");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        // while 条件 不成立
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i, w);
        }
    }


    public void dfs(){
        // 进行visited 初始化
        isVisited = new boolean[getNodeSize()];
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNodeSize(); i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


   private void bfs(boolean[] isVisited, int i){
        // 队列头的元素
        int u;
        // 第一个邻接点.
        int w;
       LinkedList<Integer> queue = new LinkedList<>();
       System.out.print(getValueByIndex(i) + ">=");
       isVisited[i] = true;
       queue.addLast(i);
       while(!queue.isEmpty()){
           // 不要用 getFirst
           u = queue.removeFirst();
           // 获取第一个 邻接节点.
           w = getFirstNeighbor(u);
           while(w != -1){
               if (!isVisited[w]){
                   System.out.print(getValueByIndex(w) + ">=");
                   isVisited[w] = true;
                   queue.addLast(w);
               }
               // 提现广度优先
               w = getNextNeighbor(u,w);
           }
       }
   }

   public void bfs(){
        isVisited = new boolean[getNodeSize()];
        for(int i = 0; i < getNodeSize(); i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
   }


    static void dfsShow(){
        //结点的个数
        int n = 5;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for(String vertex: Vertexs) {
            graph.insertNode(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E  // A-B
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示一把邻结矩阵
        graph.showGraph();
        graph.dfs();
    }

    static void bfsShow(){
        //结点的个数
        int n = 5;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for(String vertex: Vertexs) {
            graph.insertNode(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E  // A-B
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示一把邻结矩阵
        graph.showGraph();
        graph.bfs();
    }

    static void updateEdges(Graph graph){
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

    }
    public static void main(String[] args) {
       dfsShow();
        bfsShow();
    }


}
