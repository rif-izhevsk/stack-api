package com.stack.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StackApiProperties {

	private Properties properties = null;
	private static StackApiProperties instance = null;
	private static final Logger log = LogManager.getLogger(StackApiProperties.class);

	public StackApiProperties() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("stack-api.properties");
		properties = new Properties();
		try {
			properties.load(input);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public static synchronized StackApiProperties getInstance() {
		if (instance == null)
			instance = new StackApiProperties();
		return instance;
	}

	public String getValue(String key) {
		return getValue(key, null);
	}

	public String getValue(String key, String defaultValue) {
		String val = properties.getProperty(key);
		if (val == null || val.trim().isEmpty()) {
			return defaultValue;
		}
		return val;
	}
}
