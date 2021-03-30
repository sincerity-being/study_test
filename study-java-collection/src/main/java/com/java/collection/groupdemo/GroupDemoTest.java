package com.java.collection.groupdemo;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.stream.Collectors;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-01-25 11:28
 * @describe
 */
public class GroupDemoTest {

    public static void main(String[] args) throws Exception{
            //test1();
        test2();
    }

    /** 测试 code + 日期 */
  private static void test2() throws Exception{
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date1 = sdf.parse("2020-1-11");

      ArrayList<PersonBean> list = new ArrayList<>();
      PersonBean b1 = new PersonBean("200021", "张三", "男",date1);
      PersonBean b2 = new PersonBean("200021", "李四", "女",date1);
      PersonBean b3 = new PersonBean("200023", "王二麻子", "男", DateFormat.getDateInstance().parse(DateUtil.now()));
      PersonBean b4 = new PersonBean("200025", "狗蛋", "男");
      PersonBean b5 = new PersonBean("200021", "张三", "女");
      Collections.addAll(list,b1,b2,b3,b4,b5);
      System.out.println(list);
      Map<String,List<PersonBean>> map = list.stream().collect(Collectors
              .groupingBy(p -> p.getCode() + "-" + p.getBirthday()));
      System.out.println(map);
  }


    private static void test1() {
        ArrayList<PersonBean> list = new ArrayList<>();
        PersonBean b1 = new PersonBean("200021", "张三", "男");
        PersonBean b2 = new PersonBean("200025", "李四", "女");
        PersonBean b3 = new PersonBean("200023", "王二麻子", "男");
        PersonBean b4 = new PersonBean("200021", "狗蛋", "男");
        PersonBean b5 = new PersonBean("200021", "张三", "女");
        Collections.addAll(list,b1,b2,b3,b4,b5);
        List<String> repeatCode = list.stream()
                .collect(Collectors.groupingBy(PersonBean::getCode, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("repeatCode = " + repeatCode);
        System.out.println("list = " + list);
        Map<String,List<PersonBean>> mapList = list.stream()
                .collect(Collectors.groupingBy(p -> p.getCode() +"_" + p.getName()));
        System.out.println(mapList.toString());
        repeatCode.forEach(merId -> extractRepeat(list, merId));
        System.out.println("list = " + list);
    }

    public static void extractRepeat(List<PersonBean> compInfos, String repeatCode) {
            Optional<PersonBean> first = compInfos.stream()
                    .filter(o -> o.getCode().equals(repeatCode)).findFirst();
            if (first.isPresent()) {
                PersonBean bean = first.get();
                //先将所有符合这个重复的code的对象从源集合中删除.
                compInfos.removeIf(next -> next.getCode().equals(repeatCode));
                //再将取出来的第一个添加进去.
                compInfos.add(bean);
            }
        }
}

@AllArgsConstructor
@Data
class PersonBean {
    String code;
    String name;
    String sex;
    Date birthday;

    public PersonBean(String code, String name, String sex){
        this.code = code;
        this.name = name;
        this.sex = sex;
    }

}
