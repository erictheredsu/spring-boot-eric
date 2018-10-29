package com.sap.b1.eric.jackson;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JacksonJsonService {

	public Object loadJson() throws JsonProcessingException, ParseException {
		
		TransferClassUser user = new TransferClassUser();
		user.setName("Jackson");	
		user.setEmail("Jackson@sina.com");
		user.setAge(20);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(dateformat.parse("1996-10-01"));		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		
		return json;
	}

}
