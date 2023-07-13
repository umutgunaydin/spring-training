package com.company.messagingrabbitmq;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Getter
public class Receiver {

    private CountDownLatch latch=new CountDownLatch(1);

    public void receiveMessage(String message){
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }



}
