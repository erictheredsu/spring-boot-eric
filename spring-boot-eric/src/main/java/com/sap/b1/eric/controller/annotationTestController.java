package com.sap.b1.eric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"app1.properties","classpath:app2.properties"})
public class annotationTestController {
	
	@Autowired
	public InjectBean bean;
	
	@Value("this is a string") //simple string
	String testValue;
	
    @Value("#{systemProperties['os.name']}") //system property
    private String systemPropertiesName; 

    @Value("#{ T(java.lang.Math).random() * 100.0 }")	//express
    private double randomNumber; 

    @Value("#{annotationTestController.bean.another}")
    private String fromAnotherBean; // inject JaxbBean's property another，see below about defination

    @Value("classpath:static/Login.html")
    private Resource resourceFile; // inject file
    
    
    @Value("${server.port}")
    private String appPort;
    
    @Value("${server.port1}")
    private String appPort1;
    
    @Value("${server.port2}")
    private String appPort2;
    
	@GetMapping("/anno.value.simple")
	public String test1() {
		return testValue;
	}
	
	@GetMapping("/anno.value.sysprop")
	public String test2() {
		return systemPropertiesName;
	}
	
	@GetMapping("/anno.value.express")
	public double test3() {
		return randomNumber;
	}
	
	@GetMapping("/anno.value.appconif")
	public String test4() {
		return appPort + " port1:" + appPort1 + "port2: " + appPort2;
	}
	
	@GetMapping("/anno.value.beanprop")
	public String test5() {
		return fromAnotherBean;
	}
	
	
	@Component
	public class InjectBean{
		
		public InjectBean() {};
		
		@Value("this is a injected value test")
		public String another;

		public final String getAnother() {
			return another;
		}

		public final void setAnother(String another) {
			this.another = another;
		}
		
	}
}



