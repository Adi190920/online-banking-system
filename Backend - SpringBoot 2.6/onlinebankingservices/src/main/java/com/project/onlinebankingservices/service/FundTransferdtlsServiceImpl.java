package com.project.onlinebankingservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.FundTransfer;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Balancedtls;
import com.project.onlinebankingservices.respository.FundTransferdtls;

@org.springframework.stereotype.Service
public class FundTransferdtlsServiceImpl implements FundTransferdtlsService{
	
	@Autowired
	private UserdtlsServiceImpl userdtls;
	
	@Autowired
	private Balancedtls balanceRepo;
	
	@Autowired
	private FundTransferdtls fundTransferRepo;
	
	@Override
	public String doFundTransfer(FundTransfer ft) {
		//Access the details from ft first
		long srcAcc = ft.getSourceaccnumber();
		long destAcc = ft.getDestaccnumber();
		int destAccTypeid = ft.getDestacctypeid();
		double transferAmt = ft.getTransferamount();
		
		//Check the validity of accnt of sender
		Optional <User> optionalUserSrc = userdtls.findUser(srcAcc);
		//Src account is valid
		if( optionalUserSrc.isPresent()) {
			User srcUser = optionalUserSrc.get();
			//Check the balance of sender - validate it
			int srcBalanceId = srcUser.getBalanceId();
			Optional <Balance> optionalSrcBalance = balanceRepo.findById(srcBalanceId);
			Balance srcBalanceObj = optionalSrcBalance.get();
			double srcBalance = srcBalanceObj.getBalance();
			final Double srcBalanceInner = srcBalance;
			if(srcBalance >= transferAmt) {
				//Valid balance
				Optional <User> optionalUserDest = userdtls.findUser(destAcc);
				if(optionalUserDest.isPresent()){
					User destUser = optionalUserDest.get();
					int destBalanceId = destUser.getBalanceId();
					Optional <Balance> optionalDestBalance = balanceRepo.findById(destBalanceId);
					Balance destBalanceObj = optionalDestBalance.get();
					double destBalance = destBalanceObj.getBalance();
					
					//Updating src balance
					srcBalanceObj.setBalance(srcBalanceInner-transferAmt);
					balanceRepo.save(srcBalanceObj);
					
					//Updating dest balance
					destBalanceObj.setBalance(destBalance + transferAmt);
					balanceRepo.save(destBalanceObj);
					
					//Saving fund transfer obj
					fundTransferRepo.save(ft);
					return "Fund Transfer Successful!";
				}
				return "Beneficiary Not Found!";
			}
			return "Insufficient Funds in your Account!";
		}
		return "Invalid Account!";
			
	}

}
