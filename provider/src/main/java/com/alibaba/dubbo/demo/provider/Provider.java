package com.alibaba.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

    /**
     * To get ipv6 address to work, add
     * System.setProperty("java.net.preferIPv6Addresses", "true");
     * before running your application.
     */
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-provider.xml"});
        context.start();
        System.in.read(); // press any key to exit
    }
}