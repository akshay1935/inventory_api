package com.inventory.api.utility;

import java.sql.Timestamp;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:constant.properties")
public class AppUtil {

	static Logger logger = LoggerFactory.getLogger(AppUtil.class);

	public static Timestamp getCurrentSystemDate() {
		String METHOD_NAME = "Controller.getCurrentSystemDate";
		logger.info("In method {} ", METHOD_NAME);

		long currentDateMilli = System.currentTimeMillis();
		return new Timestamp(currentDateMilli);
	}

	public static String generateUniqueId() {
		return UUID.randomUUID().toString();
	}

}
