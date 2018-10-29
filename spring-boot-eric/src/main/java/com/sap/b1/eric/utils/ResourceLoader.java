package com.sap.b1.eric.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceLoader {
	
	/**
	 * @param path in classpath  eg: "xmlToParse/metatdata-simply2.xml"
	 * @return org.springframework.core.io.Resource
	 */
	public static final Resource loadFile(String path) {
	   	ApplicationContext appContext = new ClassPathXmlApplicationContext();
	   	
	    ((ConfigurableApplicationContext)appContext).close();
			
	   	//the classpath declare in pom.xml->build/resources/resource
		return appContext.getResource("classpath:" + path);
	}
}
