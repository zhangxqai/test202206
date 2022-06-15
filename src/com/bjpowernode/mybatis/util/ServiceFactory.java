package com.bjpowernode.mybatis.util;

public class ServiceFactory {
    //传递张三对象得到李四对象的过程
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
