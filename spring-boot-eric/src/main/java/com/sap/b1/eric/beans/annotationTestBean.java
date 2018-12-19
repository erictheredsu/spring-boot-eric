package com.sap.b1.eric.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"app1.properties","classpath:app2.properties"})
public class annotationTestBean {

	@Value("this is a string") //simple string
	String testValue;
	
    @Value("#{systemProperties['os.name']}") //system property
    private String systemPropertiesName; 

    @Value("#{ T(java.lang.Math).random() * 100.0 }")	//express
    private double randomNumber; 

//    @Value("#{JaxbBean.another}")
//    private String fromAnotherBean; // inject JaxbBean's property another，see below about defination

    @Value("classpath:static/Login.html")
    private Resource resourceFile; // inject file
    
    
    @Value("${server.port}")
    private String appPort;
    
    @Value("${server.port1}")
    private String appPort1;
    
    @Value("${server.port2}")
    private String appPort2;
    
	@RequestMapping("/anno.value.simple")
	public String test1() {
		return testValue;
	}
	
	@RequestMapping("/anno.value.sysprop")
	public String test2() {
		return systemPropertiesName;
	}
	
	@RequestMapping("/anno.value.express")
	public double test3() {
		return randomNumber;
	}
	
	@RequestMapping("/anno.value.appconif")
	public String test4() {
		return appPort + " port1:" + appPort1 + "port2: " + appPort2;
	}
	
}



