package com.example.demo.proxy.staticproxy;

import com.example.demo.proxy.HandlerUtil;
import com.example.demo.proxy.Invoke;
import com.example.demo.proxy.UnChangeClass;

public class ProxyClass implements Invoke {

    private UnChangeClass unChangeClass;

    public ProxyClass(UnChangeClass unChangeClass) {
        this.unChangeClass = unChangeClass;
    }

    public String requestApiA() {
        HandlerUtil.before();
        String result = unChangeClass.requestApiA();
        HandlerUtil.after();
        return result;
    }

    public String requestApiB() {
        HandlerUtil.before();
        String result = unChangeClass.requestApiB();
        HandlerUtil.after();
        return result;
    }


    public String requestApiC() {
        HandlerUtil.before();
        String result = unChangeClass.requestApiC();
        HandlerUtil.after();
        return result;
    }

    public static void main(String[] args) {
        UnChangeClass unChangeClass = new UnChangeClass();
        ProxyClass proxyClass = new ProxyClass(unChangeClass);
        proxyClass.requestApiA();
        proxyClass.requestApiB();
        proxyClass.requestApiC();
    }
}
