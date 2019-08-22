package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.model.User;
import com.example.repository.ProfileRepository;

public class ControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();

	}

	private ProfileRepository repo;

	@Test // Testing giving a userid to check its existence
	public void getUser() throws Exception {
		String uri = "/4";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		User productlist = super.mapFromJson(content, User.class);
		System.out.println(productlist);
	}

	@Test // Testing the updateUser giving a blank email
	public void updateUser() throws Exception {
		String uri = "/updateUser";
		User product = new User();
		product.setUserid(3);
		product.setFirst_name("Bhargavi");
		product.setLast_name("Bindu");
		String inputJson = super.mapToJson(product);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		// assertEquals(200, status);
		// assertEquals(content, "User Updated Successfully!");

	}

	@Test // Testing the updateUser giving invalid email
	public void updateUser1() throws Exception {

		String uri1 = "/updateUser";
		User product1 = new User();
		product1.setUserid(3);
		product1.setLast_name("123bhar");
		product1.setFirst_name("....");
		product1.setEmailid("test.com");
		product1.setPhone_no("9999999999");

		String inputJson1 = super.mapToJson(product1);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri1).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson1))
				.andReturn();

		int status1 = mvcResult.getResponse().getStatus();
		// assertEquals(200, status1);
		String content1 = mvcResult.getResponse().getContentAsString();
		// assertEquals(content1, "Saved");
		// repo.delete

	}

	@Test // Testing the updateUser giving a non-existing userid
	public void updateUser5() throws Exception {

		String uri5 = "/updateUser";
		User product5 = new User();
		product5.setUserid(34324);
		product5.setLast_name("123bhar");
		product5.setFirst_name("....");
		product5.setEmailid("test.com");
		product5.setPhone_no("9999999999");

		String inputJson5 = super.mapToJson(product5);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri5).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson5))
				.andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		System.out.println(content + "************88" + status);
		int status5 = mvcResult.getResponse().getStatus();
		assertEquals(404, status5);
		String content5 = mvcResult.getResponse().getContentAsString();
		// assertEquals(content5, "Saved");
		// repo.delete

	}

	@Test // Testing the updateUser giving a valid testcase
	public void validTestcaseForUpdateUser1() throws Exception {

		String uri3 = "/updateUser";
		User product3 = new User();
		product3.setUserid(3);
		product3.setLast_name("123bhar");
		product3.setFirst_name("....");
		product3.setEmailid("test.1.23.3@com");
		product3.setPhone_no("9999999999");

		String inputJson3 = super.mapToJson(product3);
		MvcResult mvcResult3 = mockMvc.perform(
				MockMvcRequestBuilders.post(uri3).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson3))
				.andReturn();

		int status3 = mvcResult3.getResponse().getStatus();
		assertEquals(200, status3);
		String content3 = mvcResult3.getResponse().getContentAsString();
		assertEquals(content3, "User Updated Successfully!");

	}

	@Test // Testing the updateUser giving a blank lastname
	public void updateUser2() throws Exception {
		String uri2 = "/updateUser";
		User product2 = new User();
		product2.setUserid(3);
		product2.setLast_name("");
		product2.setFirst_name("....");
		product2.setEmailid("test@com");
		product2.setPhone_no("9999@#9");

		String inputJson2 = super.mapToJson(product2);
		MvcResult mvcResult2 = mockMvc.perform(
				MockMvcRequestBuilders.post(uri2).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson2))
				.andReturn();

		int status2 = mvcResult2.getResponse().getStatus();
		System.out.println(status2);
		// assertEquals(200, status2);
		//String content2 = mvcResult2.getResponse().getContentAsString();
		// assertEquals(content2, "User Updated Successfully!");

	}

	@Test // Testing the updateUser giving a invalid mobile number non-numeric
	public void updateUser4() throws Exception {

		String uri4 = "/updateUser";
		User product4 = new User();
		product4.setUserid(3);
		product4.setLast_name("");
		product4.setFirst_name("....");
		product4.setEmailid("test.234.56@com");
		product4.setPhone_no("9999@#9");

		String inputJson4 = super.mapToJson(product4);
		MvcResult mvcResult4 = mockMvc.perform(
				MockMvcRequestBuilders.post(uri4).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson4))
				.andReturn();

		int status4 = mvcResult4.getResponse().getStatus();
		// assertEquals(404, status4);
		String content4 = mvcResult4.getResponse().getContentAsString();
		// assertEquals(content4, "User Updated Successfully!");
	}

	@Test // Testing the updateUser giving a valid testcase
	public void validTestcaseForCreateUser2() throws Exception {

		String uri6 = "/updateUser";
		User product6 = new User();
		product6.setUserid(3);
		product6.setLast_name("bhargavi");
		product6.setFirst_name("....");
		product6.setEmailid("test@gamil.com");
		product6.setPhone_no("9676386669");

		String inputJson6 = super.mapToJson(product6);
		MvcResult mvcResult6 = mockMvc.perform(
				MockMvcRequestBuilders.post(uri6).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson6))
				.andReturn();

		int status6 = mvcResult6.getResponse().getStatus();
		assertEquals(200, status6);
		String content6 = mvcResult6.getResponse().getContentAsString();
		assertEquals(content6, "User Updated Successfully!");

	}

}
