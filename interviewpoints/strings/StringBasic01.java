package com.skcoder.interviewpoints.strings;

import static java.lang.IO.println;

public class StringBasic01 {
    void main() {
        String s1 = "abc";
        s1 = "xyz";
        println(s1); //xyz

        String s2 = "java";
        s2.concat("Rocks"); //java
        println(s2);

        String s3 = "java";
        String s4 = s3.concat("Rocks"); //java
        println(s4); //javaRocks

        String s5 = "hello";
        String s6 = new String("hello");
        String s7 = s6.intern();
        println(s5 == s6); //false
        println(s5.equals(s6)); //true
        println(s5 == s7); //true
    }
}
