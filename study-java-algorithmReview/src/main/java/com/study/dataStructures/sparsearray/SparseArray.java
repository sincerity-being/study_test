package com.study.dataStructures.sparsearray;

/***
 *
 *
 *@author : HeYQ
 *@date : 2020-08-31 21:46
 *@describe :
 *@version
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11 和11
        int[][] chessArray1 = new int[11][11];
        //0 : 表示 没有棋子, 1表示黑子  2:表示蓝子
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        //输出原始的二维数组 row -- 行 column -- 列
        System.out.println("原始的二维数组");
        for (int[] row : chessArray1){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组的思路
        //1.先遍历二维数组 得到非0数据的个数
        int sum = 0;
        /*for (int i = 0 ; i < chessArray1.length; i++){
            for (int j = 0; j < chessArray1[0].length; j++){
                if (chessArray1[i][j] != 0){
                     sum++;
                }
            }
        }*/
        for (int[] row : chessArray1) {
            for (int i : row) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        //2.创建稀疏数组
        int[][] spareArray = new int[sum+1][3];
        System.out.println(spareArray.length);
        System.out.println(spareArray[0].length);
        // 3.设置值
        spareArray[0][0] = chessArray1.length;
        spareArray[0][1] = chessArray1[0].length;
        spareArray[0][2] = sum;
        int count = 1;
        for (int i = 0; i < chessArray1.length; i++){
            for (int j = 0 ; j < chessArray1[0].length; j++){
                if (chessArray1[i][j] != 0){
                    spareArray[count][0] = i;
                    spareArray[count][1] = j;
                    spareArray[count][2] = chessArray1[i][j];
                    count++;
                }
            }
        }
        for (int[] row : spareArray){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 稀疏数组 转 二维数组
        int[][] chessArray2 = new int[spareArray[0][0]][spareArray[0][1]];
        for (int i = 1; i <= spareArray[0][2]; i++){
            chessArray2[spareArray[i][0]][spareArray[i][1]] = spareArray[i][2];
        }
        for (int[] row : chessArray2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
