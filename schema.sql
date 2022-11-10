create database online_banking;
use online_banking;
create table accounts (accTypeId int AUTO_INCREMENT, accType varchar(30), primary key (accTypeId));

create table balanceDetails(balanceId int AUTO_INCREMENT, accountNumber bigint UNIQUE, 
						balance double, primary key (balanceId));  
                        
create table users(accountNumber bigint, name varchar(30), middleName varchar(30), lastName varchar(30), 
					userName varchar(30) unique,password varchar(255), securityQuestions varchar(255), 
                    securityAnswers varchar(255), accTypeId int, balanceId int, mobileNumber varchar(10), 
                    primary key (accountNumber), foreign key (accTypeId) references accounts(accTypeId),
                    foreign key(balanceId) references balanceDetails(balanceId)) ;

create table atmDetails (atmId int AUTO_INCREMENT, accountNumber bigint, atmPin int, primary key (atmId), 
						foreign key (accountNumber) references users(accountNumber));

create table fundTransfer(transferId int AUTO_INCREMENT, sourceAccNumber bigint, destAccNumber bigint, destAccTypeId int, 
							transferAmount double, primary key (transferId) );

create table transactions(transactionId int AUTO_INCREMENT, accountNumber bigint, accTypeId int, 
						transactionType varchar(30), transactionDate date, amount int, primary key (transactionId), 
						foreign key (accountNumber) references users(accountNumber), 
                        foreign key (accTypeId) references accounts(accTypeId) );

create table fixedDeposits(fixedDepositId int not Null auto_increment,accountNumber bigint,product varchar(30),period varchar(30),amount double,
							primary key (fixedDepositId),
                            foreign key (accountNumber) references users(accountNumber)
                            );
insert into accounts values(1, "savings");
insert into accounts values(2, "current");
