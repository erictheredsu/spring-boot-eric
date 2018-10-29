package com.sap.b1.eric.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.b1.eric.jaxb.JaxbService;

@RestController
@RequestMapping("/jaxb/")
public class JaxbBean {
	
	@Autowired
	private JaxbService serv;
	
	@RequestMapping("/metadata")
	String loadMetadata() {
		return serv.loadMetadata();
	}
}
