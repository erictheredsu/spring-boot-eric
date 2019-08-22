package com.sap.b1.redistest.jedis;

public class JedisConsumer {
	public void run() {
		JedisClient client = new JedisClient();
		
		
		client.getJedis().set("ddd", "ass hole");
		
		System.out.println(client.getJedis().get("ddd"));
		
		try {
			client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
