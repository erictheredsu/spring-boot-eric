package com.sap.b1.eric.jaxb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.sap.b1.eric.utils.ResourceLoader;

@Service
public class JaxbService {
	
	public String loadMetadata() {
		
		Resource res = ResourceLoader.loadFile("xmlToParse/metatdata-simply2.xml");   	
	   	StringBuilder sb = new StringBuilder();
	   	
	    try{
	     	  InputStream is = res.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	          String line;
	          while ((line = br.readLine()) != null) {
	        	  sb.append(line);
	       	  } 
	          br.close();
	        	
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	    
		return "<p>" + sb.toString() + "</p>";
	}
}
