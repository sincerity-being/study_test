package com.study.algorithm.shangguigu.review.dataStructures.tree.huffman;

import com.study.algorithm.shangguigu.review.dataStructures.tree.domain.Node;

import java.util.Arrays;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-16 19:43
 * @describe
 */
public class Main {
    /**
     * 主测试函数
     * @param args
     */
    public static void main(String[] args) {
        testHuffmanCodeContent();
    }

    public static void testHuffmanTree(){
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        HuffmanTree tree = new HuffmanTree();
        Node root = tree.createHuffmanTree(arr);
        //测试一把
        tree.preOrder(root);
    }


    public static  void testByteToBitString(){
        //测试一把byteToBitString方法
        HuffmanCodeContent huffmanCodeContent = new HuffmanCodeContent();
        System.out.println(huffmanCodeContent.byteToBitString(true,(byte)1));
    }

    public static void testHuffmanCodeContent(){
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        //40
        System.out.println(contentBytes.length);

        HuffmanCodeContent huffmanCodeContent = new HuffmanCodeContent();
        Map<Node, byte[]> huffmanNodeCodeMap = huffmanCodeContent.huffmanZip(contentBytes);
        Node huffmanCodeRoot =null;
        for (Node root : huffmanNodeCodeMap.keySet()){
            huffmanCodeRoot = root;
        }
        byte[] huffmanCodeBytes = huffmanNodeCodeMap.get(huffmanCodeRoot);

        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodeBytes)
                + " 长度= " + huffmanCodeBytes.length);

        Map<Byte, String> huffmanCodes = huffmanCodeContent.getCodes(huffmanCodeRoot);

        byte[] sourceBytes = huffmanCodeContent.decode(huffmanCodes, huffmanCodeBytes);

        // "i like like like java do you like a java"
        System.out.println("原来的字符串=" + new String(sourceBytes));
    }
}
