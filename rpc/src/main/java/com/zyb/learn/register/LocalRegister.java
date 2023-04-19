package com.zyb.learn.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LocalRegister
 * @Author zhaoyb
 * @Date 2023/4/9
 * @Version 1.0
 */
public class LocalRegister {

    private static Map<String,Class> map = new HashMap<>();

    public static void register(String interfaceName,String version, Class implClass){
        map.put(interfaceName+version,implClass);
    }

    public static Class get(String interfaceName,String version){
        return map.get(interfaceName+version);
    }
}
