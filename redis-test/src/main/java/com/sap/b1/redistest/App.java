package com.sap.b1.redistest;

import org.springframework.boot.SpringApplication;

import com.sap.b1.redistest.lettuce.StringConsumer;


public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("redis test running...");	
		
		StringConsumer sc = new StringConsumer();
		try {
			sc.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
