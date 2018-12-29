package com.sap.b1.eric;

import java.lang.management.ManagementFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = "com.sap.b1.eric.beans;com.sap.b1.eric.jaxb;com.sap.b1.eric.jackson;com.sap.b1.eric.Login")
@SpringBootApplication
public class MainStarter {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainStarter.class, args);
        
        //print 
        final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        final int index = jvmName.indexOf('@');
        System.out.print("ProcessID=" +  Long.toString(Long.parseLong(jvmName.substring(0, index))));
        
        //add proxy to use fiddler
		if(false)
		{
			System.setProperty("http.proxySet", "true");
			System.setProperty("http.proxyHost", "localhost");
			System.setProperty("http.proxyPort", "8675");
		}
    }
}