package com.stack.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResponseParser {

	private static final Logger log = LogManager.getLogger(ResponseParser.class);

	/**
	 * @param response 
	 * @return Json string extracted from GZip
	 */
	public static String parseGzip(Response response) {
		String data = new String();
		try {
			GZIPInputStream is = new GZIPInputStream((InputStream) response.getEntity());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
			data = bufferedReader.lines().collect(Collectors.joining(""));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

		log.debug("test search result {}", data);
		return data;
	}
}
