package com.info.assignment;

import com.info.assignment.heartbeat.HeartbeatThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    private static String macAddress;

    @Autowired
    private HeartbeatThread thread;

    public static void main(String[] args) {
//        macAddress = args[0];
        macAddress = "mac::Address";
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void startHeartbeatThread() {
        System.out.println(macAddress);
        thread.run(macAddress);
    }

}
