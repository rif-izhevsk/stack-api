package com.stack.srv.interfaces;

import javax.ws.rs.core.Response;

public interface StackApiService {
	/** 
	 * Test request with constant parameters
	 * @param intitle The substring in title
	 * @param page The page number
	 * @param pagesize The page size
	 * @return {@link Response}
	 */
	public Response search(String intitle, Integer page, Integer pagesize);

}
