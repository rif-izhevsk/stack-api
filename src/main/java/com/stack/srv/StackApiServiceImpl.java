package com.stack.srv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.message.GZipEncoder;

import com.stack.srv.interfaces.StackApiService;
import com.stack.ws.HelloWorldResource;

public class StackApiServiceImpl implements StackApiService {
	private static final String CLIENT_TARGET = "http://api.stackexchange.com";
	private static final String CLIENT_PATH = "/2.2/search";

	private Client client = ClientBuilder.newClient().register(GZipEncoder.class);
	private WebTarget target = null;
	private static final Logger log = LogManager.getLogger(HelloWorldResource.class);

	public StackApiServiceImpl() {
		target = client.target(CLIENT_TARGET).path(CLIENT_PATH);
	}

	@Override
	public String testSearch() {
		Invocation.Builder builder = target.queryParam("order", "desc").queryParam("sort", "activity")
				.queryParam("intitle", "java").queryParam("site", "stackoverflow")
				.request(MediaType.APPLICATION_JSON_TYPE).header(HttpHeaders.ACCEPT_ENCODING, "gzip");
		Response response = builder.get();
		String data = new String();
		try {
			GZIPInputStream is = new GZIPInputStream((InputStream)response.getEntity());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
			data = bufferedReader.lines().collect(Collectors.joining(""));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		
		log.debug("test search result {}", data);
		return data;
	}
}
