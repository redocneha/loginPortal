//package com.sapient.login;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.sapient.login.model.User;
//
//public class AuthenticationControllerTests extends AbstractTest {
//
//	private static ArrayList<User> userList;
//
//	@Override
//	@Before
//	public void setUp() {
//		super.setUp();
//	}
//
//	@BeforeClass
//	public static void populateData() {
//		userList = new ArrayList<User>();
//		userList.add(new User(2, null, "bigWorld@1"));
//		userList.add(new User(3, null, "bigWorld@1"));
//		userList.add(new User(4, null, "bigWorld@1"));
//		userList.add(new User(0, "b@gmail.com", "bigWorld@1"));
//		userList.add(new User(0, "c@gmail.com", "bigWorld@1"));
//		userList.add(new User(0, "d@gmail.com", "bigWorld@1"));
//	}
//
//	@Test
//	public void test_authenticateUserWithUserID() throws Exception {
//		String uri = "/api/authenticate";
//		String inputJson = super.mapToJson(userList.get(0));
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Authenticated");
//	}
//
//	@Test
//	public void test_authenticateUserWithUserID_wrong() throws Exception {
//		String uri = "/api/authenticate";
//		String inputJson = super.mapToJson(userList.get(1));
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Incorrect Password");
//	}
//
//	@Test
//	public void test_authenticateUserWithUserID_doesnotexist() throws Exception {
//		String uri = "/api/authenticate";
//		String inputJson = super.mapToJson(userList.get(2));
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "User doesnot exist");
//	}
//
//	@Test
//	public void test_authenticateUserWithEmailID() throws Exception {
//		String uri = "/api/authenticate";
//		String inputJson = super.mapToJson(userList.get(3));
//		System.out.println(userList.get(3));
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Authenticated");
//	}
//
//	@Test
//	public void test_authenticateUserWithEmailID_wrong() throws Exception {
//		String uri = "/api/authenticate";
//		String inputJson = super.mapToJson(userList.get(4));
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Incorrect Password");
//	}
//
//	@Test
//	public void test_authenticateUserWithEmailID_doesnotexist() throws Exception {
//		String uri = "/api/authenticate";
//		String inputJson = super.mapToJson(userList.get(5));
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "User doesnot exist");
//	}
//
//}
