package com.example.demo.proxy;

public class HandlerUtil {


    public static void before() {
        System.out.println("调用方法前增加的逻辑");
    }

    public static void after() {
        System.out.println("调用方法后增加的逻辑");
    }

}
