package com.stack.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/hello")
public class HelloWorldResource {

	private static final Logger log = LogManager.getLogger(HelloWorldResource.class.getName());

	@GET
	@Path("/{param}")
	public String getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;
		log.debug("input message {}", msg);
		return output;
	}
}