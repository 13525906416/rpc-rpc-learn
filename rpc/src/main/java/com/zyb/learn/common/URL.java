package com.zyb.learn.common;

import java.io.Serializable;

/**
 * @ClassName URL
 * @Author zhaoyb
 * @Date 2023/4/18
 * @Version 1.0
 */
public class URL implements Serializable {
    private String hostname;
    private Integer port;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public URL() {
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
