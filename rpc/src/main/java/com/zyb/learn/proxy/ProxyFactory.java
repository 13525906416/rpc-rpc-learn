package com.zyb.learn.proxy;

import com.zyb.learn.common.Invocation;
import com.zyb.learn.common.URL;
import com.zyb.learn.protocol.HttpClient;
import com.zyb.learn.loadbalance.Loadbalance;
import com.zyb.learn.register.MapRemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @ClassName ProxyFactory
 * @Author zhaoyb
 * @Date 2023/4/18
 * @Version 1.0
 */
public class ProxyFactory {
    public static <T> T getProxy(Class interfaceClass) {
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),
                        method.getParameterTypes(), args);

                HttpClient httpClient = new HttpClient();

                // 服务发现
                List<URL> list = MapRemoteRegister.get(interfaceClass.getName());
                URL url = Loadbalance.random(list);

                String result = "";

                // 服务调用
                try {
                    result = httpClient.send(url.getHostname(), url.getPort(), invocation);
                }catch (Exception e){
                    return "服务调用报错了";
                }

                return result;

            }
        });

        return (T) proxyInstance;
    }
}

