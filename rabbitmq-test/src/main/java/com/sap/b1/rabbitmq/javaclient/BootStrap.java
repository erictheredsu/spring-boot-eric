package com.sap.b1.rabbitmq.javaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BootStrap {

	private Logger logger = LoggerFactory.getLogger(BootStrap.class);
	@Autowired
	AmpqProducer ampqProducer;

//	@Autowired
//	public void setAmpqProducer(AmpqProducer ampqProducer) {
//		this.ampqProducer = ampqProducer;
//	}

	public void run()
	{
		logger.info("start publish message...");
		ampqProducer.run();
	}
	
}
