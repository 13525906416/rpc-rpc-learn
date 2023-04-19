package com.zyb.learn.service;

import com.zyb.learn.HelloServer;
import com.zyb.learn.common.URL;
import com.zyb.learn.protocol.HttpServer;
import com.zyb.learn.register.LocalRegister;
import com.zyb.learn.register.MapRemoteRegister;
import com.zyb.learn.service.impl.HelloServerImpl;
import com.zyb.learn.service.impl.HelloServerImpl2;

import java.net.MalformedURLException;


/**
 * @ClassName Provider
 * @Author zhaoyb
 * @Date 2023/4/8
 * @Version 1.0
 */
public class Provider {
    public static void main(String[] args) throws MalformedURLException {

        LocalRegister.register(HelloServer.class.getName(),"1.0", HelloServerImpl.class);
        LocalRegister.register(HelloServer.class.getName(),"2.0", HelloServerImpl2.class);
        //注册中心注册
        URL url = new URL("localhost",8080);
        MapRemoteRegister.register(HelloServer.class.getName(),url);

        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());
    }
}
