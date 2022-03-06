package com.example.demo.proxy;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

// final 情况
public class UnChangeClass {

    private static final String urlA = "http://localhost:8080/mock/api/a";
    private static final String urlB = "http://localhost:8080/mock/api/b";
    private static final String urlC = "http://localhost:8080/mock/api/c";


    public final String requestApiA() {
        String result = HttpUtil.get(urlA);
        System.out.println(JSONUtil.toJsonStr(result));
        return result;
    }


    public String requestApiB() {
        String result = HttpUtil.get(urlB);
        System.out.println(JSONUtil.toJsonStr(result));
        return result;
    }


    public String requestApiC() {
        String result = HttpUtil.get(urlC);
        System.out.println(JSONUtil.toJsonStr(result));
        return result;
    }


    public static void main(String[] args) {
        UnChangeClass unChangeClass = new UnChangeClass();
        unChangeClass.requestApiA();
        unChangeClass.requestApiB();
        unChangeClass.requestApiC();
    }
}
