//package com.sapient;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.sapient.data.model.User;
//
//public class DataRetrievalServiceTests extends AbstractTest {
//
//	@Override
//	@Before
//	public void setUp() {
//		super.setUp();
//	}
//
//	@Test
//	public void test_getUser_withEmailID() throws Exception {
//		String uri = "/api/data/user";
//		User user = new User();
//		user.setEmailID("a@gmail.com");
//		String inputJson = super.mapToJson(user);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		assertNotNull(mvcResult.getResponse().getContentAsString());
//	}
//	
//	@Test
//	public void test_getUser_withUserID() throws Exception {
//		String uri = "/api/data/user";
//		User user = new User();
//		user.setUserID(1);
//		String inputJson = super.mapToJson(user);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		assertNotNull(mvcResult.getResponse().getContentAsString());
//	}
//	
////	@Test
////	public void test_updateUser_withUserID() {
////		String uri = "/api/data/update";
////		
////		
////	}
//	
//	
//
//}
