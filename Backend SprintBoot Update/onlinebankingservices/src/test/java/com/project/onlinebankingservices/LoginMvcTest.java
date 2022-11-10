//package com.project.onlinebankingservices;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.onlinebankingservices.model.User;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LoginMvcTest {
//
//	public MockMvc mockMvc;
//	@Autowired
//	public WebApplicationContext context;
//
//	ObjectMapper om = new ObjectMapper();
//
//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//	}
//
//	@Test
//	public void addUserTest() throws Exception {
//	
//		User user1 = new User();
//		user1.setAccountnumber(1231231231);
//		user1.setUsername("admin");
//		user1.setPassword("admin");
//		user1.setBalanceid(1);
//		user1.setAcctypeid(1);
//		user1.setLastname("Joseph");
//		user1.setName("Prem");
//		user1.setMiddlename("Kumar");
//		user1.setSecurityquestions("fav color");
//		user1.setSecurityanswers("blue");
//		
//	String jsonRequest = om.writeValueAsString(user1);
//	MvcResult result = mockMvc.perform(post("/register" ).content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
//	String resultContent= result.getResponse().getContentAsString();
//	Response response =om.readValue(resultContent, Response.class);
//	assertTrue(response.getStatus()==Boolean.TRUE);
//	
//	
//}
//
//
//
//
//}