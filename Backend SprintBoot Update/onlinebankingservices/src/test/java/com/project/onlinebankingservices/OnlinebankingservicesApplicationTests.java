package com.project.onlinebankingservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.FundTransfer;
import com.project.onlinebankingservices.respository.Balancedtls;
import com.project.onlinebankingservices.respository.FundTransferdtls;
import com.project.onlinebankingservices.service.FundTransferdtlsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
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

	@MockBean
	Balancedtls balanceRepo;

	@MockBean
	FundTransferdtls fundTransferRepo;

	@Autowired
	FundTransferdtlsService ftService;

	@MockBean
	FundTransfer fundTransfer;

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
		User user1 = createUserObject(1231231231, 1, 1);
		
		String pass="newpassword";
		
		when(repository.updateUserPassword(pass,user1.getAccountnumber())).thenReturn(1);
		assertEquals(1,uService.updateUserPassword(pass,user1.getAccountnumber()));
		
	}

	@ParameterizedTest(name = "{3}")
	@MethodSource("getFundTransfer")
	public void checkFundTransfer(FundTransfer fundTransfer, double srcBalance, double destBalance, String response) {
		long srcAcc = fundTransfer.getSourceaccnumber();
		long destAcc = fundTransfer.getDestaccnumber();
		User srcUser = createUserObject(1231231231, 1, 1);
		User destUser = createUserObject(1231231232, 1, 1);
		Balance srcBalanceObj = createBalanceObject(1, 1231231231, srcBalance);
		Balance destBalanceObj = createBalanceObject(1, 1231231232, destBalance);

		when(repository.findById(srcAcc)).thenReturn(Optional.of(srcUser));
		when(balanceRepo.findById(srcUser.getBalanceid())).thenReturn(Optional.of(srcBalanceObj));
		when(repository.findById(destAcc)).thenReturn(Optional.of(destUser));
		when(balanceRepo.findById(destUser.getBalanceid())).thenReturn(Optional.of(destBalanceObj));
		when(balanceRepo.save(srcBalanceObj)).thenReturn(srcBalanceObj);
		when(balanceRepo.save(destBalanceObj)).thenReturn(destBalanceObj);
		when(fundTransferRepo.save(fundTransfer)).thenReturn(fundTransfer);

		ResponseEntity<String> responseEntity = ftService.doFundTransfer(fundTransfer);

		assertEquals(responseEntity.getBody(), response);
	}

	public static Stream<Arguments> getFundTransfer() {

		FundTransfer fundTransfer1 = createFundTransferObject(1231231231, 1231231232, 5, 1, 100);
		FundTransfer fundTransfer2 = createFundTransferObject(1231231231, 1231231232, 5, 1, 10000);
		FundTransfer fundTransfer3 = createFundTransferObject(1231231231, 1231231232, 5, 2, 100);


		return Stream.of(
			Arguments.of(fundTransfer1, 1000,500, "Fund Transfer Successful!"),
				Arguments.of(fundTransfer2, 1000,500, "Insufficient Funds in your Account!"),
				Arguments.of(fundTransfer3, 1000,500, "Beneficiary Account Type is invalid")
		);
	}

	public static FundTransfer createFundTransferObject(long srcAccNo, long destAccNo, int transferId, int destAccTypeId, double amount) {

		FundTransfer fundTransfer = new FundTransfer();

		fundTransfer.setSourceaccnumber(srcAccNo);
		fundTransfer.setDestaccnumber(destAccNo);
		fundTransfer.setTransferid(transferId);
		fundTransfer.setDestacctypeid(destAccTypeId);
		fundTransfer.setTransferamount(amount);

		return fundTransfer;
	}

	public User createUserObject(long accountNumber, int balanceId, int accTypeId) {
		User user1 = new User();
		user1.setAccountnumber(accountNumber);
		user1.setUsername("admin");
		user1.setPassword("admin");
		user1.setBalanceid(balanceId);
		user1.setAcctypeid(accTypeId);
		user1.setLastname("Joseph");
		user1.setName("Prem");
		user1.setMiddlename("Kumar");
		user1.setSecurityquestions("fav color");
		user1.setSecurityanswers("blue");
		return user1;
	}

	public Balance createBalanceObject(int balanceId, long accountNumber, double balanceInput){
		Balance balance1 = new Balance();
		balance1.setAccountnumber(accountNumber);
		balance1.setBalanceid(balanceId);
		balance1.setBalance(balanceInput);

		return balance1;
	}
}
