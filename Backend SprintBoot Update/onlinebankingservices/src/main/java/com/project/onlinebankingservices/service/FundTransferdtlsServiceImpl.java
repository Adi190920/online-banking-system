package com.project.onlinebankingservices.service;

import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.FundTransfer;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Accountsdtls;
import com.project.onlinebankingservices.respository.Balancedtls;
import com.project.onlinebankingservices.respository.FundTransferdtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@org.springframework.stereotype.Service
public class FundTransferdtlsServiceImpl implements FundTransferdtlsService {

    @Autowired
    private UserdtlsServiceImpl userdtls;

    @Autowired
    private Balancedtls balanceRepo;

    @Autowired
    private Accountsdtls accountsRepo;

    @Autowired
    private FundTransferdtls fundTransferRepo;

    @Override
    public String doFundTransfer(FundTransfer ft) {
        try {
            //Access the details from ft first
            long srcAcc = ft.getSourceaccnumber();
            long destAcc = ft.getDestaccnumber();
            int destAccTypeId = ft.getDestacctypeid();
            double transferAmt = ft.getTransferamount();

            //Checking if the sourceAccount is valid
            Optional<User> optionalUserSrc = userdtls.findUser(srcAcc);
            if (optionalUserSrc.isPresent()) {
                //Source account is valid
                User srcUser = optionalUserSrc.get();
                //Checking if the balance of Sender is greater than or equal to the transfer amount
                int srcBalanceId = srcUser.getBalanceid();
                Optional<Balance> optionalSrcBalance = balanceRepo.findById(srcBalanceId);
                Balance srcBalanceObj = optionalSrcBalance.get();
                double srcBalance = srcBalanceObj.getBalance();
                final Double srcBalanceInner = srcBalance;
                if (srcBalance >= transferAmt) {
                    //Balance validation of Source Account is successful
                    Optional<User> optionalUserDest = userdtls.findUser(destAcc);
                    //Checking if the destination account is valid
                    if (optionalUserDest.isPresent()) {
                        //Destination account number is valid
                        User destUser = optionalUserDest.get();
                        int destAccountTypeIdDB = destUser.getAcctypeid();
                        if (destAccTypeId == destAccountTypeIdDB) {
                            //Destination Account Type is valid
                            int destBalanceId = destUser.getBalanceid();
                            Optional<Balance> optionalDestBalance = balanceRepo.findById(destBalanceId);
                            Balance destBalanceObj = optionalDestBalance.get();
                            double destBalance = destBalanceObj.getBalance();

                            //Updating source account balance
                            srcBalanceObj.setBalance(srcBalanceInner - transferAmt);
                            balanceRepo.save(srcBalanceObj);

                            //Updating destination account balance
                            destBalanceObj.setBalance(destBalance + transferAmt);
                            balanceRepo.save(destBalanceObj);

                            //Saving fund transfer object
                            fundTransferRepo.save(ft);
                            return "Fund Transfer Successful!";
                        }
                        return "Beneficiary Account Type is invalid";
                    }
                    return "Beneficiary Account Not Found!";
                }
                return "Insufficient Funds in your Account!";
            }
            return "Invalid Source Account!";
        } catch (Exception e) {
            return "Fund Transfer processing failed!";
        }
    }

}
