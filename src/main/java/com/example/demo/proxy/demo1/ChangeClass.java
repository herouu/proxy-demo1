//package com.example.demo.proxy.demo1;
//
//import com.example.demo.proxy.HandlerUtil;
//import com.example.demo.proxy.UnChangeClass;
//
//public class ChangeClass extends UnChangeClass {
//
//
//    @Override
//    public String requestApiA() {
//        HandlerUtil.before();
//        String result = super.requestApiA();
//        HandlerUtil.after();
//        return result;
//
//    }
//
//    @Override
//    public String requestApiB() {
//        HandlerUtil.before();
//        String result = super.requestApiB();
//        HandlerUtil.after();
//        return result;
//    }
//
//    @Override
//    public String requestApiC() {
//        HandlerUtil.before();
//        String o = super.requestApiC();
//        HandlerUtil.after();
//        return o;
//    }
//
//    public static void main(String[] args) {
//        ChangeClass changeClass = new ChangeClass();
//        changeClass.requestApiA();
//        changeClass.requestApiB();
//        changeClass.requestApiC();
//    }
//}
