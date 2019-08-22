package com.sap.b1.redistest.jedis;

import redis.clients.jedis.Jedis;

public class JedisClient implements AutoCloseable {
	private Jedis jedis;
	
	public JedisClient() {
		jedis = new Jedis("10.58.136.142");
		jedis.select(1);	
		
		if(jedis.ping().equalsIgnoreCase("Pong"))
		{
			System.out.println("Jedis connect ok");
		}
		else
		{
			System.out.println("Jedis connect fail");
		}
	}

	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	@Override
	public void close() throws Exception {
		jedis.close();
		System.out.println("Jedis closed");
	}
	
	
}
