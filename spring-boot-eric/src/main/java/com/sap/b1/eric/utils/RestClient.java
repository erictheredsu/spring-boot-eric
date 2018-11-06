package com.sap.b1.eric.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class RestClient {
	public final static String SL_URL = "http://10.59.62.108:50001/b1s/v1";
	
    public static ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 60000;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }
    
    private static String B1Session;
	public static final String getB1Session() {
		return B1Session;
	}

	public static final void setB1Session(String b1Session) {
		B1Session = b1Session;
	}

}
