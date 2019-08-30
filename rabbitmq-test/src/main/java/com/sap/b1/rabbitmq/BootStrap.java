package com.sap.b1.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.sap.b1.rabbitmq.javaclient.AmpqProducer;

@Controller
public class BootStrap {

	private Logger logger = LoggerFactory.getLogger(BootStrap.class);
	
//	@Autowired
//	@Qualifier("ampqProducer")
//	AmpqProducer ampqProducer;
	
	public void run()
	{
		logger.info("start publish message...");
		Runnable ampqProducer = new AmpqProducer(); ; 
		ampqProducer.run();
	}
	
}
