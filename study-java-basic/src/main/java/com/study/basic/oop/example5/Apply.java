package com.study.basic.oop.example5;

import static com.study.basic.util.Print.print;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 12:04
 * @describe
 */
public class Apply {

    public static String s =
            "Disagreement with beliefs is by definition incorrect";


    public static void process(Processor p, Object s){
        print("Using Processor " + p.name());
        print(p.process(s));
    }


}
