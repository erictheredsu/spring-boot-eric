package com.sap.b1.rabbitmq.javaclient;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sap.b1.rabbitmq.constants.RabbitmqConsts;

@Controller
public class AmpqProducer implements Runnable {

	
	Connection conn;
	public Connection getConn() {
		return conn;
	}

	@Autowired
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	Channel chProduce = null;

	private Logger logger = LoggerFactory.getLogger(AmpqProducer.class);
	
	public void run() 
	{
		try {
			init();
			
			createQueue();
			
			publishMsg();
			
			close();
			
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		
	}


	public void init() throws IOException, TimeoutException
	{
		chProduce =  conn.createChannel();
	}
	
	private void createQueue() {
	}
	
	private void publishMsg() throws IOException
	{
		byte[] messageBodyBytes = "Hello, world!".getBytes();
		chProduce.basicPublish(RabbitmqConsts.Exchange_Name, "topic.hello", null, messageBodyBytes);
		
		messageBodyBytes = "aaaaaaa".getBytes();
		chProduce.basicPublish(RabbitmqConsts.Exchange_Name, "topic.a", null, messageBodyBytes);
		
		messageBodyBytes = "bbbb".getBytes();
		chProduce.basicPublish(RabbitmqConsts.Exchange_Name, "direct.aaa", null, messageBodyBytes);
	}
	
	private void close() throws IOException, TimeoutException {
		chProduce.close();
		
	}
	
}
