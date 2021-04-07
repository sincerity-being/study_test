package com.java.st.collection.mapDemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-02-02 11:56
 * @describe
 */
public class MapAddressDemo {

    public static void main(String[] args) {
        Person p1 = new Person("hyq",24);
        Person p2 = new Person("123" ,123);
        List<Person> personList = new ArrayList<>(10);
        personList.add(p1);
        personList.add(p2);
        Map<String,List<Person>>  mapList = personList.stream()
                .collect(Collectors.groupingBy(Person::getUserName));
        System.out.println(mapList.toString());
        List<Person> k1 = mapList.get("hyq");
        k1.get(0).setUserName("1234");
        System.out.println(mapList.toString());

        final int countSize = personList.size() ;
        System.out.println(countSize);
        for (int i = 0; i < countSize; i++){
            System.out.println(i + 1);
            System.out.println((i+1)==countSize);
        }

    }

}
@AllArgsConstructor
@Data
class Person{
    String userName;
    Integer age;
}