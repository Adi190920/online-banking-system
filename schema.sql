drop database online_banking;
create database online_banking;
use online_banking;
create table accounts (accTypeId int, AccType varchar(30), primary key (accTypeId));
create table balancedetails(balanceId int, balance double, accountNumber int, primary key (balanceId));
create table users(accountNumber int, name varchar(30), middleName varchar(30), lastName varchar(30), 
					userName varchar(30),password varchar(30), securityquestions varchar(255), 
                    securityAnswers varchar(255), accTypeId int, mobileNumber varchar(10), balanceId int,
                    primary key (accountNumber), foreign key (accTypeId) references accounts(accTypeId), 
                    foreign key (balanceId) references balancedetails(balanceId));
create table atmDetails (id int, accountNumber int, atmPin int, primary key (id), 
						foreign key (accountNumber) references users(accountNumber));
create table checkBookDetails( checkBookId int, accountNumber int, requestedDate date, issueDate date, 
								priority int, primary key (checkBookId),
                                foreign key (accountNumber) references users(accountNumber));
create table fundTransfer(transferId int, soureAccNumber int, destAccNumber int, DestAccTypeId int, 
							transferAmount double, primary key (transferId) );

create table transactions(transactionId int, accountNumber int, accTypeId int, 
						transactionType varchar(30), transactionDate date, amount int, primary key (transactionId), 
						foreign key (accountNumber) references users(accountNumber), 
                        foreign key (accTypeId) references accounts(accTypeId) );
insert into accounts values(1, "savings");
insert into accounts values(2, "current");