create database guestbook

create table message(
	 id int not null auto_incrememt primary key
	,guestname varchar(50) not null
	,password varchar(50) not null
	,message text not null
);