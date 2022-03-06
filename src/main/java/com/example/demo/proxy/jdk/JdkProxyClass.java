package com.example.demo.proxy.jdk;

import com.example.demo.proxy.HandlerUtil;
import com.example.demo.proxy.Invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyClass implements InvocationHandler {

    private ChangeClass changeClass;

    public JdkProxyClass(ChangeClass changeClass) {
        this.changeClass = changeClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HandlerUtil.before();
        Object invoke = method.invoke(changeClass, args);
        HandlerUtil.after();
        return invoke;
    }


    public static void main(String[] args) {
        ChangeClass changeClass = new ChangeClass();
        InvocationHandler jdkProxyClass = new JdkProxyClass(changeClass);
        Invoke proxy = (Invoke) Proxy.newProxyInstance(jdkProxyClass.getClass().getClassLoader(), new Class[]{Invoke.class}, jdkProxyClass);
        proxy.requestApiA();
        proxy.requestApiB();
        proxy.requestApiC();
    }
}
