package com.sap.b1.redistest;

import org.springframework.boot.SpringApplication;

import com.sap.b1.redistest.jedis.JedisConsumer;
import com.sap.b1.redistest.lettuce.LettuceConsumer;


public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("redis test running...");	
		
		LettuceConsumer lc = new LettuceConsumer();
		lc.run();
		
		JedisConsumer jc = new JedisConsumer();
		jc.run();
		
		System.out.println("redis test finish ...");	
		
		
	}
}
