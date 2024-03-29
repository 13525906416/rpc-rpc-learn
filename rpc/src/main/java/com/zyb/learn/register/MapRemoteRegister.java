package com.zyb.learn.register;

import com.zyb.learn.common.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MapRemoteRegister
 * @Author zhaoyb
 * @Date 2023/4/18
 * @Version 1.0
 */
public class MapRemoteRegister {

    private static Map<String, List<URL>> map = new HashMap<>();

    public static void register(String interfaceName, URL url){
        List<URL> list  = map.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);

        map.put(interfaceName, list);

        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        map = getFile();

        return map.get(interfaceName);
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
