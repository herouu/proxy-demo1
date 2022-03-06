package com.example.demo.proxy.cglib;

import com.example.demo.proxy.HandlerUtil;
import com.example.demo.proxy.UnChangeClass;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyClass implements MethodInterceptor {

    private UnChangeClass unChangeClass;

    public CglibProxyClass() {
    }

    public CglibProxyClass(UnChangeClass unChangeClass) {
        this.unChangeClass = unChangeClass;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        HandlerUtil.before();
        Object invoke = methodProxy.invokeSuper(o, args);
//        Object invoke = method.invoke(unChangeClass, args);
        HandlerUtil.after();
        return invoke;
    }


    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UnChangeClass.class);

//        CglibProxyClass cglibProxyClass = new CglibProxyClass();
//        enhancer.setCallback(cglibProxyClass);

        CglibProxyClass cglibProxyClass1 = new CglibProxyClass(new UnChangeClass());
        enhancer.setCallback(cglibProxyClass1);

        UnChangeClass unChangeClass = (UnChangeClass) enhancer.create();
        unChangeClass.requestApiA();
        unChangeClass.requestApiB();
        unChangeClass.requestApiC();
    }
}
