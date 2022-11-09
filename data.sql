use online_banking;
insert into accounts values(1,"savings");
insert into accounts values(2,"current");

insert into balanceDetails values(1,1212598807,10000);
insert into balanceDetails values(2,1212598808,10000);
insert into balanceDetails values(3,1212598810,10000);
insert into balanceDetails values(4,1212598811,10000);
insert into balanceDetails values(5,1212598823,10000);


select * from accounts;
INSERT INTO users VALUES
(1212598807,"Rishabh","Vignesh","Singh","rishabh231atmdetails","password123","What is your pet's name","Timmy",2,1,"9982367794");
select * from users;
INSERT INTO users VALUES
(1212598808,"Anush","K","Verma","anush","password234","What is your pet's name","Oreo",1,2,"8082347794");
INSERT INTO users VALUES (1212598810,"Sara","L","Dsouza","sara1","Password_12","What is your pet's name","Oreo",1,3,"8082347794");
INSERT INTO users VALUES
(1212598811,"Sruthi","Bala","Krishnan","sruthi_bal","password_shru","What is your pet's name","Johnny",1,4,"9854909331");
INSERT INTO users VALUES (1212598823,"Karen","P","Smith","ksmith","pwd_123890","What is your pet's name","John",2,5,"6002323294");
select * from users;


INSERT INTO atmdetails values (1,1212598807,2507);
INSERT INTO atmdetails values (2,1212598808,1227);
INSERT INTO atmdetails values (3,1212598810,1478);
INSERT INTO atmdetails values (4,1212598811,7836);
INSERT INTO atmdetails values (5,1212598823,1239);

INSERT INTO checkbookdetails values(1,1212598807,23/05/2022,23/06/2022,1);
INSERT INTO checkbookdetails values(2,1212598808,17/04/2022,29/05/2022,1);
INSERT INTO checkbookdetails values(3,1212598810,02/06/2022,01/08/2022,2);
INSERT INTO checkbookdetails values(4,1212598811,23/07/2022,30/07/2022,1);

INSERT INTO fundtransfer values(1,1212598807,1212598808,1,1500);
INSERT INTO fundtransfer values(2,1212598807,1212598808,1,3500);
INSERT INTO fundtransfer values(3,1212598807,1212598808,1,25000);
INSERT INTO fundtransfer values(4,1212598807,1212598808,1,2300);
INSERT INTO fundtransfer values(5,1212598807,1212598808,1,1000);
INSERT INTO fundtransfer values(6,1212598807,1212598808,1,7500);
INSERT INTO fundtransfer values(7,1212598807,1212598808,1,4500);
INSERT INTO fundtransfer values(8,1212598807,1212598808,1,35000);
INSERT INTO fundtransfer values(9,1212598807,1212598808,1,3300);
INSERT INTO fundtransfer values(10,1212598807,1212598808,1,10000);
INSERT INTO fundtransfer values(11,1212598810,1212598811,3,1500);
INSERT INTO fundtransfer values(12,1212598810,1212598811,3,3500);
INSERT INTO fundtransfer values(13,1212598810,1212598811,3,25000);atmdetails
INSERT INTO fundtransfer values(14,1212598811,1212598823,2,2300);
INSERT INTO fundtransfer values(15,1212598811,1212598823,2,1000);
INSERT INTO fundtransfer values(16,1212598811,1212598823,2,1500);
INSERT INTO fundtransfer values(17,1212598811,1212598823,2,3500);
INSERT INTO fundtransfer values(18,1212598810,1212598807,2,25000);
INSERT INTO fundtransfer values(19,1212598810,1212598807,2,2300);
INSERT INTO fundtransfer values(20,1212598810,1212598807,2,1000);