package com.sap.b1.eric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sap.b1.eric.beans;com.sap.b1.eric.jaxb;com.sap.b1.eric.jackson;com.sap.b1.eric.Login")
public class MainStarter {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainStarter.class, args);
    }
}