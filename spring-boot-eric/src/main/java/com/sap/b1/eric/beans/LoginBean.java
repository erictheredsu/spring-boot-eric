package com.sap.b1.eric.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.b1.eric.Login.LoginInfo;
import com.sap.b1.eric.Login.LoginService;

@RestController
public class LoginBean {
	
	@Autowired
	private LoginService serv;
	
	@PostMapping("/Login.do")
	public String login(@ModelAttribute() LoginInfo info ) {
		return serv.doLoginServiceLayer(info);
	}
}
