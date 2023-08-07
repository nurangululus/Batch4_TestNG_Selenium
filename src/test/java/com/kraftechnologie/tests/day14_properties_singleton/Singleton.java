package com.kraftechnologie.tests.day14_properties_singleton;

public class Singleton {

    private Singleton(){}
    private static String str;

    public static String getInstance(){
        if(str==null){
            System.out.println("str is null, assigning a value to it");
            str="chrome";
        }else {
            System.out.println("It has value, just returning it");
        }
        return str;
    }
}
