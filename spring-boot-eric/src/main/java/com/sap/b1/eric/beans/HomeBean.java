package com.sap.b1.eric.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeBean {
    @RequestMapping("/")
    String home() {
    	return "Login.html"; //or return "forward:Login.html"
    }
}
