package com.sap.b1.eric.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.b1.eric.rest.RestInfo;
import com.sap.b1.eric.rest.ServiceLayerService;

@RestController
public class RestTemplateBean {
	
	@Autowired
	private ServiceLayerService serv;
	
	@RequestMapping("/rest.do")
	public String execute(@ModelAttribute() RestInfo info) {
		return serv.doSLRequest(info);
	}
	

}
