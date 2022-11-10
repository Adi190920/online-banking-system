//package com.project.onlinebankingservices;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.project.onlinebankingservices.exceptions.NotFoundException;
//import com.project.onlinebankingservices.model.Balance;
//import com.project.onlinebankingservices.model.FundTransfer;
//import com.project.onlinebankingservices.model.Logindata;
//import com.project.onlinebankingservices.model.User;
//import com.project.onlinebankingservices.respository.Balancedtls;
//import com.project.onlinebankingservices.respository.FundTransferdtls;
//import com.project.onlinebankingservices.respository.Usersdtls;
//import com.project.onlinebankingservices.service.FundTransferdtlsService;
//import com.project.onlinebankingservices.service.LoginServiceImpl;
//import com.project.onlinebankingservices.service.UserdtlsService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LoginMethodTest {
//
//	@MockBean
//	Usersdtls repository;
//
//	@Autowired
//	LoginServiceImpl loginService;
//
//	@MockBean
//	Logindata ld;
//
//	@ParameterizedTest(name = "{3}")
//	@MethodSource("getLogin")
//	public void checkLogin(Logindata ld, String response) throws NotFoundException {
//		String username = ld.getUsername();
//		String password = ld.getPassword();
//
//		User srcUser = createUserObject(12312312311L, username, password);
//
//		when(repository.findByUsername(username)).thenReturn(Optional.of(srcUser));
//
//		ResponseEntity<User> responseEntity = loginService.getloggedin(ld);
//		assertEquals(responseEntity.getBody(), srcUser);
//
//	}
//
//	public static Stream<Arguments> getLogin() {
//
//		Logindata loginData1 = createLoginObject("anush", "password234");
//		Logindata loginData2 = createLoginObject("sara1", "Password_12");
//		Logindata loginData3 = createLoginObject("wfcp", "random");
//
//		return Stream.of(Arguments.of(loginData1), Arguments.of(loginData2), Arguments.of(loginData3));
//	}
//
//	public User createUserObject(Long accountNumber, String username, String password) {
//		User user1 = new User();
//		user1.setAccountnumber(accountNumber);
//		user1.setUsername(username);
//		user1.setPassword(password);
//		user1.setBalanceid('1');
//		user1.setAcctypeid('1');
//		user1.setLastname("Joseph");
//		user1.setName("Prem");
//		user1.setMiddlename("Kumar");
//		user1.setSecurityquestions("fav color");
//		user1.setSecurityanswers("blue");
//		return user1;
//	}
//
//	public static Logindata createLoginObject(String Username, String Password) {
//		Logindata user = new Logindata();
//		user.setUsername(Username);
//		user.setPassword(Password);
//		return user;
//	}
//}
