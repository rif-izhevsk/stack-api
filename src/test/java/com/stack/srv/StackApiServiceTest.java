package com.stack.srv;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.BeforeClass;
import org.junit.Test;

import com.stack.srv.interfaces.StackApiService;

public class StackApiServiceTest {

	private static StackApiService stackApiService;
	
	@BeforeClass
	public static void initTest() {
		stackApiService = new StackApiServiceImpl();
	}

	@Test
	public void test() {
		Response response = stackApiService.search("java");
		assertEquals(200, response.getStatus());
	}

}