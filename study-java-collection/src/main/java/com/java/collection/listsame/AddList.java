package com.java.collection.listsame;

import java.util.ArrayList;
import java.util.List;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-14 16:47
 *@describe:
 *@version:
 */
public class AddList {

    public static void main(String[] args) {
        List<User>  users = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        users.add(user);

        user.setAge(19);
       users.add(user);

        System.out.println("user size()" + users.size());
        System.out.println("users==" + users);

    }
}
