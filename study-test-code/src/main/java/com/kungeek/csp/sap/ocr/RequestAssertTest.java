package com.kungeek.csp.sap.ocr;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 注释..
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class RequestAssertTest {

    public static void main(String[] args) {
        User user = new User();
        List<Object> validList = new ArrayList<>(10);
        validList.add(user.getUsername());
        System.out.println("validList:{}" + validList);
        RequestAssertTest.notEmpty(validList,"至少填写一项");
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new RuntimeException( message+ "不能为空");
        }
    }
}

class User{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
