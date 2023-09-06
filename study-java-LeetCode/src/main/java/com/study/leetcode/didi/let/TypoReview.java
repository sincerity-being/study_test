package com.study.leetcode.enterprise.didi.let;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-10 14:55
 * @describe
 */
public class TypoReview {
    static HashSet<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'));
    static HashSet<Character> set2 = new HashSet<>(Arrays.asList('y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        String word = words[0];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2) {
                if(node1.distance != node2.distance){
                    return node2.distance - node1.distance;
                }else{
                    return node2.index - node1.index;
                }
            }
        });
        for(int i = 1; i < words.length; i++){
            int dis = editDistance(word, words[i]);
            Node node = new Node(i - 1, words[i], dis);
            if(pq.size() < 3){
                pq.offer(node);
            }else{
                if(pq.peek().distance > dis){
                    pq.poll();
                    pq.offer(node);
                }
            }
        }
        // 输出top3，注意不足3个的情况
        ArrayList<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll().word);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int editDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            // 删除i个字符
            dp[i][0] = 3*i;
        }
        for(int j = 0; j <= m; j++){
            // 插入i个字符
            dp[0][j] = 3*j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    // 字符相等直接转移
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    // 替换、删除、插入的代价选择最小的
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + replaceCost(word1, word2, i, j),
                            Math.min(dp[i - 1][j], dp[i][j - 1]) + 3
                    );
                }
            }
        }
        return dp[n][m];
    }

    private static int replaceCost(String word1, String word2, int i, int j) {
        char c1 = word1.charAt(i - 1);
        char c2 = word2.charAt(j - 1);
        if((set1.contains(c1) && set2.contains(c2)) || (set1.contains(c2) && set2.contains(c1))){
            return 2;
        }else{
            return 1;
        }
    }
}
class Node {
    int index;
    String word;
    int distance;
    public Node(int index, String word, int distance) {
        this.index = index;
        this.word = word;
        this.distance = distance;
    }
}
