package com.sap.b1.eric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.b1.eric.jaxb.JaxbService;

@RestController
@RequestMapping("/jaxb/")
public class JaxbController {
	
	@Autowired
	private JaxbService serv;
	
	@GetMapping("/metadata")
	String loadMetadata() {
		return serv.loadMetadata();
	}
	
	// for test of @Value
    @Value("demo :other bean's property")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
