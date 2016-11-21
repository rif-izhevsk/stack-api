package com.stack.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Project properties' reader
 */
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

	/**
	 * 
	 * @return The singleton instance
	 */
	public static synchronized StackApiProperties getInstance() {
		if (instance == null)
			instance = new StackApiProperties();
		return instance;
	}

	/**
	 * Gets property value
	 * @param key The key of property
	 * @return The property value
	 */
	public String getValue(String key) {
		return getValue(key, null);
	}

	/**
	 * Gets property value. If value is empty defaultValue is returned
	 * @param key The key of property
	 * @param defaultValue The default value
	 * @return The property value
	 */
	public String getValue(String key, String defaultValue) {
		String val = properties.getProperty(key);
		if (val == null || val.trim().isEmpty()) {
			return defaultValue;
		}
		return val;
	}
}
