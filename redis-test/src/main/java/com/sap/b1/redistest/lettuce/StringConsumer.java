package com.sap.b1.redistest.lettuce;

public class StringConsumer {

	public void run() throws Exception
	{
		LettuceClient client = new LettuceClient();
		client.getConn().set("aaa", "aaa111");
		client.getConn().set("bbb", "bbb111");
		
		
		System.out.println(client.getConn().get("aaa"));
		System.out.println(client.getConn().get("bbb"));
		
		client.close();
	}
}
