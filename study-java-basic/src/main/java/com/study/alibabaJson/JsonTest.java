package com.study.alibabaJson;

import com.alibaba.fastjson.JSONObject;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-12 13:45
 *@describe:
 *@version:
 */
public class JsonTest {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(16);
        System.out.println(JSONObject.toJSONString(user));
    }




}
