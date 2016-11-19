package com.stack.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stack.srv.StackApiServiceImpl;
import com.stack.srv.interfaces.StackApiService;

@Path("/stack")
public class StackApiWebService {
	private static final Logger log = LogManager.getLogger(HelloWorldResource.class);
	private StackApiService stackApiService = new StackApiServiceImpl();

	@GET
	@Path("/test")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String search() {
		log.debug("Test search");
		return stackApiService.testSearch();
	}
}
