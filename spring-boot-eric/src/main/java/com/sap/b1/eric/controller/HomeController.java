package com.sap.b1.eric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller //have to use @Controller, RestController doesn't work for forwarding htmls
public class HomeController {
	@GetMapping("/")
    String home() {
    	return "Login.html"; //or return "forward:Login.html"
    }
    
    
    @GetMapping("/datatest")
    String dataTest() {
    	return "DataTest.html";
    }
    
    @GetMapping("/api")
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}