package com.sapient.password;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapient.password.model.User;

public class ChangePasswordControllerTests extends AbstractTest {

	private static ArrayList<User> userList;

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@BeforeClass
	public static void populateData() {
		userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserID(1);
		user1.setOldpwd("smallWorld@1"); //correct pwd
		user1.sethashedPwd("smallWorld@2");
		userList.add(user1);
		
		User user2 = new User();
		user1.setUserID(2);
		user1.setOldpwd("bigWorld"); //incorrect pwd
		user1.sethashedPwd("smallWorld@2");
		userList.add(user2);
		
		User user3 = new User();
		user1.setUserID(10); //user doesn't exist
		user1.setOldpwd("peace");
		user1.sethashedPwd("peaceWorld");
		userList.add(user3);
		
//		userList.add(new User(0, "b@gmail.com", "bigWorld@1"));
//		userList.add(new User(0, "c@gmail.com", "bigWorld@1"));
//		userList.add(new User(0, "d@gmail.com", "bigWorld@1"));
	}
	
	@Test
	public void test_changePasswordWithUserID() throws Exception {
		String uri = "/api/change";
		String inputJson = super.mapToJson(userList.get(0));
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Password changed successfully");
	}

	@Test
	public void test_changePasswordWithUserID_incorrectPwd() throws Exception {
		String uri = "/api/change";
		String inputJson = super.mapToJson(userList.get(1));
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Please enter correct password");
	}

	@Test
	public void test_changePasswordWithUserID_doesnotexist() throws Exception {
		String uri = "/api/change";
		String inputJson = super.mapToJson(userList.get(2));
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "User doesnot exist");
	}

	/*
	 * @Test public void test_authenticateUserWithEmailID() throws Exception {
	 * String uri = "http://localhost:8091/api/authenticate"; String inputJson =
	 * super.mapToJson(userList.get(3)); System.out.println(userList.get(3));
	 * MvcResult mvcResult = mvc.perform(
	 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
	 * ).content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString();
	 * assertEquals(content, "Authenticated"); }
	 * 
	 * @Test public void test_authenticateUserWithEmailID_wrong() throws Exception {
	 * String uri = "http://localhost:8091/api/authenticate"; String inputJson =
	 * super.mapToJson(userList.get(4)); MvcResult mvcResult = mvc.perform(
	 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
	 * ).content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString();
	 * assertEquals(content, "Incorrect Password"); }
	 * 
	 * @Test public void test_authenticateUserWithEmailID_doesnotexist() throws
	 * Exception { String uri = "http://localhost:8091/api/authenticate"; String
	 * inputJson = super.mapToJson(userList.get(5)); MvcResult mvcResult =
	 * mvc.perform(
	 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
	 * ).content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString();
	 * assertEquals(content, "User doesnot exist"); }
	 */

}
