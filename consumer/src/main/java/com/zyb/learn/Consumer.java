package com.zyb.learn;

import com.zyb.learn.common.Invocation;
import com.zyb.learn.protocol.HttpClient;
import com.zyb.learn.proxy.ProxyFactory;

import java.util.List;

/**
 * @ClassName Consumer
 * @Author zhaoyb
 * @Date 2023/4/8
 * @Version 1.0
 */
public class Consumer {
    public static void main(String[] args) {
//        HelloServer helloServer = ProxyFactory.getProxy(HelloServer.class);
//        String result = helloServer.sayHello("zhaoyb");
        List<String> s = null;
        System.out.println( s!= null && s.size()>0);
//        System.out.println(result);
    }
}
