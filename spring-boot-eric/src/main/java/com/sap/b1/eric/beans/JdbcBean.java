package com.sap.b1.eric.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.b1.eric.jdbc.DaoSEVT;

@RestController
public class JdbcBean {
	
	@Autowired
	private DaoSEVT sevt;
	
    @GetMapping(value = "sevt", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object GetSEVTRecords() throws Exception 
    {
    	sevt.setSchema("SBOCOMMON");
    	return sevt.getData();
    }

}