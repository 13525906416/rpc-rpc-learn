package com.zyb.learn.loadbalance;

import com.zyb.learn.common.URL;

import java.util.List;
import java.util.Random;

/**
 * @ClassName Loadbalance
 * @Author zhaoyb
 * @Date 2023/4/18
 * @Version 1.0
 */
public final class Loadbalance {
    //随机轮询
    public static URL random(List<URL> urls){
        Random random = new Random();
        int i = random.nextInt(urls.size());
        return urls.get(i);
    }
}
