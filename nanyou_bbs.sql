drop database BBS;
CREATE DATABASE BBS DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
	use  BBS;

	create table user
		(
			userid int primary key not null,
			username varchar(255),
			userpassword varchar(255),
			islock boolean default false
			);
	create table administrator
		(
			 adminid int primary key,
			 adminname varchar(255),
			 adminpassword varchar(255) 
			);
	create table board
		(
			boardid int  primary key AUTO_INCREMENT not null,
			boardtitle varchar(255),
			boardsign varchar(255)
			);
	create table poster
		(
			posterid int primary key AUTO_INCREMENT,
			boardid int,
            userid int,
			counter int default 0,
			postertitle varchar(255) not null ,
			postercontent text,
			seqnum int default 0,
			postertime datetime,
			foreign key (boardid) references board(boardid),
			foreign key (userid) references user(userid)
			)AUTO_INCREMENT = 1;
	create table reply
		(
			replyid int primary key AUTO_INCREMENT,
			posterid int,
			userid int,
			replycontent text,
			replytime datetime,
			foreign key (posterid) references poster(posterid),
			foreign key (userid) references user(userid)
			)AUTO_INCREMENT = 1;
insert into user (userid,username,userpassword) values(1,'1','1');
insert into user (userid,username,userpassword) values(2,'2','2');	

insert into administrator values(000,'000','000');

insert into board (boardtitle,boardsign) values ('课程','这是课程板块'); 	
insert into board (boardtitle,boardsign) values ('饭堂','这是饭堂板块');
insert into board (boardtitle,boardsign) values ('宿舍','这是宿舍板块');
insert into board (boardtitle,boardsign) values ('教室','这是教室板块');
insert into board (boardtitle,boardsign) values ('图书馆','这是图书馆板块');
insert into board (boardtitle,boardsign) values ('留言板','这是留言板');

select * from user;
select * from board;
select * from administrator;
select * from poster;
select * from poster order by boardid,seqnum,postertime;
select * from reply;

update poster set seqnum=0;
SET SQL_SAFE_UPDATES = 0;
