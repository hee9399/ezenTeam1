drop database if exists gorider;
create database gorider;
use gorider;

drop table if exists member;
create table member(
    mno int auto_increment ,     		# 회원번호              	
    mname varchar(20) not null ,		# 회원이름              		
    mid varchar(20) not null,  			# 회원아이디		
    mpwd varchar(20) not null,			# 회원비밀번호 
    memail varchar(50) not null unique,	# 회원이메일
    mphone varchar(13) not null,		# 회원전화번호
	mpayinfo varchar(16) not null,		# 결제카드번호
    mdate datetime default now(),		# 회원등록일
    primary key( mno )
);

drop table if exists rider;
create table rider(
    rno int auto_increment ,     		# 라이더번호              	
    rname varchar(20) not null ,		# 라이더이름              		
    rid varchar(20) not null,  			# 라이더아이디		
    rpwd varchar(20) not null,			# 라이더비밀번호 
    rphone varchar(13) not null,		# 라이더전화번호
	rphoto longtext,					# 라이더프로필사진 //이미지
    rlicense longtext,					# 면허증  //이미지
    rregistration longtext,				# 차량등록증  //이미지
    rdate datetime default now(),		# 등록일
    raccount varchar(20),				# 계좌번호
    rstatus varchar(1),					# 승인상태
    rcomment text,						# 승인거부시 사유
    primary key( rno )
);

drop table if exists service;
create table service(
	sno	int auto_increment,				# 서비스번호
	mno int, 				    		# 회원번호  
    rno int  ,     						# 회원번호              	
    sdate datetime default now(),		# 서비스이용일
    sfromla double,						# 서비스 시작위치 위도
    sfromlo double,						# 서비스 시작위치 경도
    stola double,						# 서비스 도착위치 위도
    stolo double,						# 서비스 도착위치 경도
    spayment int,						# 서비스결제금액
    spayYN varchar(1),					# 결제여부
    sreview text,						# 리뷰
    spoint int,							# 별점
    primary key( sno ),
    foreign key( mno) references member(mno),
	foreign key( rno) references rider(rno)
);

drop table if exists deposit;
create table deposit (
	dno int auto_increment,			# 입금번호
    rno int  ,     					# 라이더번호
    ddate datetime default now(),	# 입금일
    ddeposit int,					# 입금액
	primary key( dno ),
    foreign key( rno) references rider(rno)
);


select * from member;
select * from rider;
select * from service;
select * from deposit;
