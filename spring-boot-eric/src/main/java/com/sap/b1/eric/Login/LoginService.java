package com.sap.b1.eric.Login;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import com.sap.b1.eric.utils.RestClient;

@Service
public class LoginService {
	
	public static String COOKIE = "Set-Cookie";

	public String doLoginServiceLayer(LoginInfo info){
		
		String url = RestClient.SL_URL + "/Login";
		ClientHttpRequestFactory factory = RestClient.getClientHttpRequestFactory();
		RestTemplate rest = new RestTemplate(factory);
		
		String postData = String.format("{ \"CompanyDB\": \"%s\",\"UserName\": \"%s\", \"Password\": \"%s\"}", 
				info.getCompany(),info.getUsername(), info.getPassword());
		HttpEntity<String> entity = new HttpEntity<String>(postData, null);
		ResponseEntity<String> response = rest.exchange(url, HttpMethod.POST, entity, String.class);
		
		if(response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
			return "Invalid username and password";
		}
		
		for(String key : response.getHeaders().keySet()) {
			if(key.equals(COOKIE)) {
				String b1Session = response.getHeaders().get(key).get(0);
				RestClient.setB1Session(b1Session);
			}
		}
		
		String rc = response.getBody();
		rc += "\r\n\r\n<a href=\\dataTest>go to Data Test Page</a>";
		
		return rc;
	}
}
