package com.sap.b1.rabbitmq;

import java.lang.management.ManagementFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sap.b1.rabbitmq.javaclient.BootStrap;

@SpringBootApplication(scanBasePackages = "com.sap.b1.rabbitmq.javaclient")
public class App 
{	
    public static void main( String[] args )
    {
        //print ProcessID 
        final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        final int index = jvmName.indexOf('@');
        System.out.print("ProcessID=" +  Long.toString(Long.parseLong(jvmName.substring(0, index))) + " RabbitMQ test start...");
        
    	ApplicationContext app = SpringApplication.run(App.class, args); 	
    	BootStrap boot  = (BootStrap) app.getBean(BootStrap.class);
    	boot.run();
    	
    }

    	

    	
        
}
