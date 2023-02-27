package com.pubAndsub;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ListenerA implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("我是ListenerA");
    }
}
