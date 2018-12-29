package com.sap.b1.eric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.b1.eric.Login.LoginInfo;
import com.sap.b1.eric.Login.LoginService;
import com.sap.b1.eric.jdbc.DaoSEVT;
import com.sap.b1.eric.rest.RestInfo;
import com.sap.b1.eric.rest.ServiceLayerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "general", tags = "General API")
public class generalServiceController {

	//Login 
	@Autowired
	private LoginService serv;
	@PostMapping("/login.do")
	public String login(@ModelAttribute() LoginInfo info ) {
		return serv.doLoginServiceLayer(info);
	}	
	
	
	//jdbc
	@Autowired
	private DaoSEVT sevt;
    @GetMapping(value = "/sevt", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object GetSEVTRecords() throws Exception 
    {
    	sevt.setSchema("SBOCOMMON");
    	return sevt.getData();
    }	
	
	@Autowired
	private ServiceLayerService slServ;
	
	//TODO: what is these means?
	@ApiOperation(value = "adapter for ServiceLayer", notes = " can do Add, Update, delete, Get operation, not finish yet", response = String.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "RestInfo", value = "Service Layer Request info", required = true, /*dataType = "String",*/ paramType = "body")})
	@RequestMapping("/rest.do")
	public String execute(@ModelAttribute() RestInfo info) {
		return slServ.doSLRequest(info);
	}
}
