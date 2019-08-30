package com.sap.b1.rabbitmq.javaclient;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Configuration
@PropertySource({"application.yml"})
public class ClientConfig {
	
	 @Value("${spring.rabbitmq.username}")
	 private String userName;
	 
	 @Value("${spring.rabbitmq.password}")
	 private String password;
	 
	 @Value("${spring.rabbitmq.virtual-host}")
	 private String virtualHost;
	 
	 @Value("${spring.rabbitmq.host}")
	 private String hostName;
	 
	 @Value("${spring.rabbitmq.portNumber}")
	 private int portNumber;
	 
	 @Value("${spring.rabbitmq.connection-timeout}")
	 private int timeout;
	
	@Autowired
	ConnectionFactory factory;
	 
	@Bean
	public Connection getConnection() throws IOException, TimeoutException 
	{
		return factory.newConnection();
	}
	
	@Bean
	public ConnectionFactory getConnectionFactory() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(userName);
		factory.setPassword(password);
		factory.setVirtualHost(virtualHost);
		factory.setHost(hostName);
		factory.setPort(portNumber);
		factory.setConnectionTimeout(timeout);
		return factory;
	}
	
	
	
}
