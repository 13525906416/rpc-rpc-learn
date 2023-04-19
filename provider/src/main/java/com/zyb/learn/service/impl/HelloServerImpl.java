package com.zyb.learn.service.impl;

import com.zyb.learn.HelloServer;

/**
 * @ClassName HelloServerImpl
 * @Author zhaoyb
 * @Date 2023/4/8
 * @Version 1.0
 */
public class HelloServerImpl implements HelloServer {

    @Override
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
