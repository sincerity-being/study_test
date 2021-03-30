package com.study.book.crazyjava.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-02-23 14:26
 * @describe
 */
@Slf4j
public class ConnMysql {

    static {
        // 这种方式 耦合 而且注册了两次.
      /*  try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
           log.error("出现异常");
        }*/
    }

    public static void main(String[] args) throws Exception{
        // 1. 加载驱动,使用反射的知识
        //  com.mysql.jdbc.Driver 8.0 过时驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        try{
             connection = DriverManager.getConnection("");
             connection.setAutoCommit(false);
             connection.getAutoCommit();
        }catch(Exception e){
           log.error(" e:{}",e);

        }finally{
          connection.close();
        }

    }
}
