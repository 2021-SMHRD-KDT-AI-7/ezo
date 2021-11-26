create table BBSuser1(
	userID varchar2(20),
	userPassword varchar2(20),
	userName varchar2(20),
	userGender varchar2(20),
	userEmail varchar2(50)
);

create table bbs(
bbsID varchar2(50),
userID varchar2(20),
bbsDate date,
bbsContent varchar2(2000),
bbsAvailable integer
);