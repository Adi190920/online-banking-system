//package com.project.onlinebankingservices;
//
//import org.junit.runner.RunWith;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.project.onlinebankingservices.model.User;
//import com.project.onlinebankingservices.respository.Usersdtls;
//import com.project.onlinebankingservices.service.AccountsdtlsService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class OnlinebankingservicesApplicationTests {
//
//
//
//    @MockBean
//    Usersdtls repository;
//    
//    @Autowired
//    AccountsdtlsService accountService;
//
//  
//
//    @Test
//    public void testGetAccount(){
//
//        User user = new User();
//        user.setAccountnumber(12312312312);
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user.setBalanceid(1);
//       
//
//
//        Account newAcc = new Account();
//        newAcc.setUsername("jai");
//        newAcc.setPassword("1234");
//
//        when(bankRepository.findByUsernameAndPassword(anyString(),anyString())).thenReturn(acc);
//        Account tk = accountService.getAccount(newAcc);
//
//        assert(tk.getAccountNumber().equals("1234"));
//        assert(tk.getUsername().equals("amar"));
//        assert(tk.getPassword().equals("!@#$"));
//        assert(Objects.equals(tk.getBalance(), 1000));
//        assert(Objects.equals(tk.getAtmPin(), 8271));
//        assert(tk.getFirstName().equals("Amarnaath"));
//        assert(tk.getLastName().equals("M"));
//        assert(tk.getMiddleName().equals("Am"));
//        assert(Objects.equals(tk.getFdBalance(),10000));
//    }
//
//    @Test
//    public void testCreateHappyFlow(){
//        Account acc = new Account();
//        acc.setUsername("Amarnaath");
//        when(bankRepository.findByUsername(anyString())).thenReturn(null);
//        accountService.create(acc);
//    }
//
//    @Test
//    public void testCreateAccountAlreadyExists(){
//
//        Account acc = new Account();
//        acc.setAccountNumber("1234");
//        acc.setUsername("amar");
//        acc.setPassword("!@#$");
//        acc.setBalance(1000);
//        acc.setAtmPin(8271);
//        acc.setFirstName("Amarnaath");
//        acc.setLastName("M");
//        acc.setMiddleName("Am");
//        acc.setFdBalance(10000);
//
//        Account acc2 = new Account();
//        acc2.setUsername("amar");
//        when(bankRepository.findByUsername(anyString())).thenReturn(acc);
//
//        accountService.create(acc2);
//    }
//
//    @Test
//    public void testUpdate(){
//        Account newAcc = new Account();
//        newAcc.setUsername("jai");
//        newAcc.setPassword("1234");
//        accountService.update(newAcc);
//    }
//}
//	
//	
//	
//
//}
