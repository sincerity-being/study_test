package com.study.algorithm.shangguigu.review.dataStructures.tree.huffman;

import com.study.algorithm.shangguigu.review.dataStructures.tree.domain.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-16 21:32
 * @describe
 */
public class HuffmanCodeContent {


    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    //   生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    private static  Map<Byte, String> huffmanCodes = new HashMap<>();
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
    private static StringBuilder stringBuilder = new StringBuilder();

    //使用一个方法，将前面的方法封装起来，便于我们的调用.
    /**
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 是经过 赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    public  Map<Node,byte[]> huffmanZip(byte[] bytes) {
        Map<Node,byte[]> nodeCodeMap = new HashMap<>(16);
        List<Node> nodes = getNodes(bytes);
        //根据 nodes 创建的赫夫曼树
        HuffmanTree tree = new HuffmanTree();
        Node huffmanTreeRoot = tree.createHuffmanTree(nodes);
        //对应的赫夫曼编码(根据 赫夫曼树)
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        nodeCodeMap.put(huffmanTreeRoot, zip(bytes, huffmanCodes));
        return nodeCodeMap;
    }


    //编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
    /**
     *
     * @param bytes 这时原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     * 举例： String content = "i like like like java do you like a java"; =》 byte[] contentBytes = content.getBytes();
     * 返回的是 字符串 "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     * => 对应的 byte[] huffmanCodeBytes  ，即 8位对应一个 byte,放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] =  10101000(补码) => byte  [推导  10101000=> 10101000 - 1 => 10100111(反码)=> 11011000= -88 ]
     * huffmanCodeBytes[1] = -88
     */
    private byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for(byte b: bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //System.out.println("测试 stringBuilder~~~=" + stringBuilder.toString());

        //将 "1010100010111111110..." 转成 byte[]

        //统计返回  byte[] huffmanCodeBytes 长度
        //一句话 int len = (stringBuilder.length() + 7) / 8;
        int len;
        if(stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) { //因为是每8位对应一个byte,所以步长 +8
            String strByte;
            if(i+8 > stringBuilder.length()) {//不够8位
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    //为了调用方便，我们重载 getCodes
    public Map<Byte, String> getCodes(Node root) {
        if(root == null) {
            return null;
        }
        //处理root的左子树
        getCodes(root.getLeft(), "0", stringBuilder);
        //处理root的右子树
        getCodes(root.getRight(), "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合
     * @param node  传入结点
     * @param code  路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
    private  void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code 加入到 stringBuilder2
        stringBuilder2.append(code);
        if(node != null) { //如果node == null不处理
            //判断当前node 是叶子结点还是非叶子结点
            if(node.getData() == null) { //非叶子结点
                //递归处理
                //向左递归
                getCodes(node.getLeft(), "0", stringBuilder2);
                //向右递归
                getCodes(node.getRight(), "1", stringBuilder2);
            } else { //说明是一个叶子结点
                //就表示找到某个叶子结点的最后
                huffmanCodes.put(node.getData(), stringBuilder2.toString());
            }
        }
    }


    /**
     *
     * @param bytes 接收字节数组
     * @return 返回的就是 List 形式   [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......],
     */
    private  List<Node> getNodes(byte[] bytes) {
        //1创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();

        //遍历 bytes , 统计 每一个byte出现的次数->map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { // Map还没有这个字符数据,第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        //遍历map
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;

    }

    //完成数据的解压
    //思路
    //1. 将huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    //   重写先转成 赫夫曼编码对应的二进制的字符串 "1010100010111..."
    //2.  赫夫曼编码对应的二进制的字符串 "1010100010111..." =》 对照 赫夫曼编码  =》 "i like like like java do you like a java"


    //编写一个方法，完成对压缩数据的解码
    /**
     *
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    public byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for(int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte>  map = new HashMap<String,Byte>();
        for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for(int  i = 0; i < stringBuilder.length(); ) {
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while(flag) {
                //1010100010111...
                //递增的取出 key 1
                String key = stringBuilder.substring(i, i+count);//i 不动，让count移动，指定匹配到一个字符
                b = map.get(key);
                if(b == null) {//说明没有匹配到
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到 count
        }
        //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
        //把list 中的数据放入到byte[] 并返回
        byte b[] = new byte[list.size()];
        for(int i = 0;i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }



    /**
     * 将一个byte 转成一个二进制的字符串, 如果看不懂，可以参考我讲的Java基础 二进制的原码，反码，补码
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    public  String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b
        int temp = b; //将 b 转成 int
        //如果是正数我们还存在补高位
        if(flag) {
            temp |= 256; //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        //返回的是temp对应的二进制的补码
        String str = Integer.toBinaryString(temp);
        if(flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }



}
