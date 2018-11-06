package com.sap.b1.eric.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sap.b1.eric.utils.RestClient;

@Service
public class ServiceLayerService {
	public String doSLRequest(RestInfo info) {
		
		ClientHttpRequestFactory factory = RestClient.getClientHttpRequestFactory();	
		RestTemplate rest = new RestTemplate(factory);
			
		HttpMethod method = info.getMethod().equals("POST") ? HttpMethod.POST : HttpMethod.GET;
		
		MultiValueMap<String, String> Headers = new LinkedMultiValueMap<String, String>();
		Headers.add("Cookie", RestClient.getB1Session());
		Headers.add("Accept", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity<String>(info.getPostData(), Headers);
		String requestUrl = RestClient.SL_URL + "/" + info.getUrl().trim();
		//String requestUrl = "http://127.0.0.1:8675/" + info.getUrl().trim();
	
		ResponseEntity<String> response = null;
		try {
			 response  = rest.exchange(requestUrl, method, requestEntity, String.class);
		}
		catch(HttpClientErrorException e){
			String msg = e.getMessage();
			msg += "\r\n" + e.getResponseBodyAsString();	
			return msg;
		}
		
		return response.getBody();
	}
}
