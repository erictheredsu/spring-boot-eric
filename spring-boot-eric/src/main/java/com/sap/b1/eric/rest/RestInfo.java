package com.sap.b1.eric.rest;

public class RestInfo {
	
	private String url;
	private String postData;
	private String method;
	public final String getMethod() {
		return method;
	}
	public final void setMethod(String method) {
		this.method = method;
	}
	public final String getUrl() {
		return url;
	}
	public final void setUrl(String url) {
		this.url = url;
	}
	public final String getPostData() {
		return postData;
	}
	public final void setPostData(String postData) {
		this.postData = postData;
	}

}
