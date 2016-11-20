package com.stack.srv.interfaces;

import javax.ws.rs.core.Response;

public interface StackApiService {
	/** 
	 * Test request with constant parameters
	 * @param intitle substring in title
	 * @return {@link Response}
	 */
	public Response search(String intitle);

}
