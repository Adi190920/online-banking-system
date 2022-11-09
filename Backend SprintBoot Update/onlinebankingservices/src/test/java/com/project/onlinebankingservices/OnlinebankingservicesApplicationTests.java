package com.project.onlinebankingservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Usersdtls;
import com.project.onlinebankingservices.service.UserdtlsService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlinebankingservicesApplicationTests {

	@MockBean
	Usersdtls repository;

	@Autowired
	UserdtlsService uService;

	@Test
	public void getUsersTest() {

		User user1 = new User();
		user1.setAccountnumber(1231231231);
		user1.setUsername("admin");
		user1.setPassword("admin");
		user1.setBalanceid(1);
		user1.setAcctypeid(1);
		user1.setLastname("Joseph");
		user1.setName("Prem");
		user1.setMiddlename("Kumar");
		user1.setSecurityquestions("fav color");
		user1.setSecurityanswers("blue");
		
		User user2 = new User();
		user2.setAccountnumber(123456789);
		user2.setUsername("pass");
		user2.setPassword("pass");
		user2.setBalanceid(0);
		user2.setAcctypeid(1);
		user2.setLastname("Charlie");
		user2.setName("P");
		user2.setMiddlename("Kumar");
		user2.setSecurityquestions("fav color");
		user2.setSecurityanswers("blue");
		
		when(repository.findAll()).thenReturn(Stream.of(user1,user2).collect(Collectors.toList()));
		assertEquals(2, uService.getUsers().size());
	}

	@Test
	public void getUsersByUsername()
	{
		User user1 = new User();
		user1.setAccountnumber(1231231231);
		user1.setUsername("admin");
		user1.setPassword("admin");
		user1.setBalanceid(1);
		user1.setAcctypeid(1);
		user1.setLastname("Joseph");
		user1.setName("Prem");
		user1.setMiddlename("Kumar");
		user1.setSecurityquestions("fav color");
		user1.setSecurityanswers("blue");
		
		User user2 = new User();
		user2.setAccountnumber(123456789);
		user2.setUsername("pass");
		user2.setPassword("pass");
		user2.setBalanceid(0);
		user2.setAcctypeid(1);
		user2.setLastname("Charlie");
		user2.setName("P");
		user2.setMiddlename("Kumar");
		user2.setSecurityquestions("fav color");
		user2.setSecurityanswers("blue");
		
		when(repository.findByUsername("admin")).thenReturn(Optional.of(user2));
		assertEquals(Optional.of(user2),uService.findUserByUsername("admin"));
	}
	
	
	@Test
	public void CreateUser()
	{
		User user1 = new User();
		user1.setAccountnumber(1231231231);
		user1.setUsername("admin");
		user1.setPassword("admin");
		user1.setBalanceid(1);
		user1.setAcctypeid(1);
		user1.setLastname("Joseph");
		user1.setName("Prem");
		user1.setMiddlename("Kumar");
		user1.setSecurityquestions("fav color");
		user1.setSecurityanswers("blue");
		
		
		when(repository.save(user1)).thenReturn(user1);
		assertEquals(user1,uService.createUser(user1));
		
	}
	
	@Test
	public void findUserbyAccNum()
	{
		User user1 = new User();
		user1.setAccountnumber(1231231231);
		user1.setUsername("admin");
		user1.setPassword("admin");
		user1.setBalanceid(1);
		user1.setAcctypeid(1);
		user1.setLastname("Joseph");
		user1.setName("Prem");
		user1.setMiddlename("Kumar");
		user1.setSecurityquestions("fav color");
		user1.setSecurityanswers("blue");
		
		
		when(repository.findById(user1.getAccountnumber())).thenReturn(Optional.of(user1));
		assertEquals(Optional.of(user1),uService.findUser(user1.getAccountnumber()));
		
	}
	
	@Test
	public void updateUserpassword()
	{
		User user1 = new User();
		user1.setAccountnumber(1231231231);
		user1.setUsername("admin");
		user1.setPassword("admin");
		user1.setBalanceid(1);
		user1.setAcctypeid(1);
		user1.setLastname("Joseph");
		user1.setName("Prem");
		user1.setMiddlename("Kumar");
		user1.setSecurityquestions("fav color");
		user1.setSecurityanswers("blue");
		
		String pass="newpassword";
		
		when(repository.updateUserPassword(pass,user1.getAccountnumber())).thenReturn(1);
		assertEquals(1,uService.updateUserPassword(pass,user1.getAccountnumber()));
		
	}
	
}
