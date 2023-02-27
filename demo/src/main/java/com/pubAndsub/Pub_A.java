package com.pubAndsub;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

public class Pub_A  implements ApplicationContextAware {
    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext =applicationContext;
    }

//    public void publishEvent(ApplicationEvent event){
//        System.out.println("publish event");
//        applicationContext.publishEvent(event);
//    }

    public void publish(ApplicationEvent event){
        System.out.println("publish event");
        applicationContext.publishEvent(event);
    }

    //注册

}
