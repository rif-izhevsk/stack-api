package com.stack.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stack.srv.StackApiServiceImpl;
import com.stack.srv.interfaces.StackApiService;

@Path("/")
public class StackApiWebService {
	private static final Logger log = LogManager.getLogger(StackApiWebService.class);
	private StackApiService stackApiService = new StackApiServiceImpl();

	@GET
	@Path("/search")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response search(@QueryParam("intitle") String intitle) {
		log.debug("Test search");
		return stackApiService.search(intitle);
	}
}
