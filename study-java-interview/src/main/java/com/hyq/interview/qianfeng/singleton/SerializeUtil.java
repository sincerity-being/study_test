package com.hyq.interview.qianfeng.singleton;

import java.io.*;

/**
 * @author 徒有琴
 */
public class SerializeUtil {
    public static void serialize(Object obj) {
        ObjectOutputStream output = null;
        try {
            File file = new File("obj");
            output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(obj);
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object unzerialize() {
        ObjectInputStream input = null;
        try {
            File file = new File("obj");
            input = new ObjectInputStream(new FileInputStream(file));
            // 2.读取
            Object object = input.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
