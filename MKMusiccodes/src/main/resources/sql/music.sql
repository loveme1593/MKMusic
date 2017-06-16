
create table musicuser (
	user_id			varchar2(20) primary key,	
	user_password	varchar2(20) not null,		
	user_name		varchar2(30) not null,		
        user_type            varchar2(30) not null,         
        user_password_q      number,                         
        user_password_a      varchar2(200) not null          
);

create table musiccd (
	cdnum		number	primary key,			
	artist		varchar2(100) not null,			
	title		varchar2(200) not null,			
	price		number default 0,				
        sell_id         varchar2(20) not null,                               
        quantity        number default 0
);

create table musicsales (
	buy_id			varchar2(20),			
	cdnum		number,					
	quantity	number default 0,		
	amount		number default 0,		
	salesdate	date default sysdate,	
	constraint musicsales_fk foreign key(cdnum) 
		references musiccd(cdnum) on delete cascade
);


insert into musiccd values (1, 'Al Di Meola', 'Morocco Fantasia', 20000);
insert into musiccd values (2, 'Amy Winehouse', 'Back To Black', 10000);
insert into musiccd values (3, 'Dream Theater', 'Images And Words', 15000);
insert into musiccd values (4, 'Nightwish', 'Oceanborn', 13000);
insert into musiccd values (5, 'Metallica', 'Ride The Lightning', 17000);

--sequence(cdnum)
create sequence cdnum_seq;

