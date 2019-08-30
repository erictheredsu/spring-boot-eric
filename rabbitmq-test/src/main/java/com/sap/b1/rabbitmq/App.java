package com.sap.b1.rabbitmq;

import java.lang.management.ManagementFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sap.b1.rabbitmq.javaclient")
public class App 
{	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	
        //print ProcessID 
        final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        final int index = jvmName.indexOf('@');
        System.out.print("ProcessID=" +  Long.toString(Long.parseLong(jvmName.substring(0, index))) + " RabbitMQ test start...");
    	
        BootStrap boot = new BootStrap();
        boot.run();
    }
}
