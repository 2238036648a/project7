package com.mr.pdm.locktest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class test {


    public static void main(String[] args) {
        singleThred();

    }


    public static void singleThred(){
        long startTime = System.currentTimeMillis();
        for(int i=0; i<10000000; i++ ){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
    }

}
