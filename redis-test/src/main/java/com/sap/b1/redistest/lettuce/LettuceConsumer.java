package com.sap.b1.redistest.lettuce;

public class LettuceConsumer {

	public void run()
	{
		LettuceClient client = new LettuceClient();
		client.getConn().set("aaa", "aaa111");
		client.getConn().set("bbb", "bbb111");
		
		
		System.out.println(client.getConn().get("aaa"));
		System.out.println(client.getConn().get("bbb"));
		
		try {
			client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
