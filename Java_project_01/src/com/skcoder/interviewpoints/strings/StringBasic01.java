package com.skcoder.interviewpoints.strings;

public class StringBasic01 {
    void main() {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2); //true
        String str3 = new String("hello");
        System.out.println(str1 == str3); //false

        String str4 = "abc";
        str4 = "xyz";
        System.out.println(str4); //xyz

        String str5 = "java";
        str5.concat("Rocks"); //java
        System.out.println(str5);

        String str6 = "java";
        String str7 = str6.concat("Rocks"); //java
        System.out.println(str7); //javaRocks

        String str8 = "hello";
        String str9 = new String("hello");
        String str10 = str9.intern();
        System.out.println(str8 == str9); //false
        System.out.println(str8.equals(str9)); //true
        System.out.println(str8 == str10); //true
    }
}
