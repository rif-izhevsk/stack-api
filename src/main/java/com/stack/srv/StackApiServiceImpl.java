package com.stack.srv;

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

import com.stack.prop.StackApiProperties;
import com.stack.srv.interfaces.StackApiService;

public class StackApiServiceImpl implements StackApiService {
	private static final String CLIENT_TARGET = "http://api.stackexchange.com";
	private static final String CLIENT_PATH = "/2.2/search";

	private Client client = ClientBuilder.newClient().register(GZipEncoder.class);
	private WebTarget target = null;
	private static final Logger log = LogManager.getLogger(StackApiServiceImpl.class);

	public StackApiServiceImpl() {
		target = client.target(StackApiProperties.getInstance().getValue("client.target", CLIENT_TARGET))
				.path(StackApiProperties.getInstance().getValue("client.path", CLIENT_PATH));
	}

	@Override
	public Response search(String intitle, Integer page, Integer pagesize) {
		log.info("search intitle='{}' & page='{}' & pagesize='{}' ", intitle);
		WebTarget webTarget = target.queryParam("intitle", intitle).queryParam("site", "stackoverflow");
		if (page != null && page > 1)
			webTarget = webTarget.queryParam("page", page);
		if (pagesize != null && pagesize > 0)
			webTarget = webTarget.queryParam("pagesize", pagesize);
		Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.header(HttpHeaders.ACCEPT_ENCODING, "gzip");
		return builder.get();
	}

}
