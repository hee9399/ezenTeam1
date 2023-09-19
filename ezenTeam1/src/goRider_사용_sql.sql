drop database if exists gorider;
create database gorider;
use gorider;

# ---------------------------------------------------  정의어 ------------------------------------------------------------------------------
drop table if exists member;
create table member(
    mno int auto_increment ,     		# 회원번호
    mname varchar(20) not null ,		# 회원이름
    mid varchar(20) not null,  			# 회원아이디
    mpwd varchar(20) not null,			# 회원비밀번호
    memail varchar(50) not null unique,	# 회원이메일
	mpayinfo varchar(16) not null,		# 결제카드번호
    mdate datetime default now(),		# 회원등록일
    primary key( mno )
);
drop table if exists rider;
create table rider(
    rno int auto_increment ,     			# 라이더번호
    rname varchar(20) not null ,		# 라이더이름
    rid varchar(20) not null,  			# 라이더아이디
    rpwd varchar(20) not null,			# 라이더비밀번호
    rphone int not null , 					# 라이더 전화번호
	rphoto longtext,							# 라이더프로필사진 //이미지
    rlicense longtext,							# 면허증  //이미지
    rregistration longtext,					# 차량등록증  //이미지
    rdate datetime default now(),		# 등록일
    raccount varchar(20),					# 계좌번호
     rbank varchar(3) , 					# 라이더 은행명
    rstatus varchar(1),						# 승인상태
    rcomment text,							# 승인거부시 사유
    primary key( rno )
);

# 	 라이더상태테이블 - 라이더번호 , 라이더출근상태 , 라이더콜가능상태
drop table if exists riderstate;
create table riderstate(
	 rno int ,     			# 라이더번호
     rstart varchar(2) ,    # 라이더출근상태
     rcall varchar(2) ,  	# 라이더콜가능상태
     foreign key(rno) references rider(rno) on delete cascade on update cascade
);

drop table if exists service;
create table service(
	sno	int auto_increment,				# 서비스번호
	mno int, 				    		# 회원번호
    rno int  ,     						# 회원번호
    sdate datetime default now(),		# 서비스이용일
    sfromla varchar(30) ,						# 서비스 시작위치 위도
    sfromlo varchar(30),						# 서비스 시작위치 경도
    stola varchar(30),						# 서비스 도착위치 위도
    stolo varchar(30),						# 서비스 도착위치 경도
    spayment int,						# 서비스결제금액
    spayYN varchar(1),					# 결제여부
    sreview text,						# 리뷰
    spoint int,							# 별점
    primary key( sno ),
    foreign key( mno) references member(mno) on delete cascade on update cascade ,
	foreign key( rno) references rider(rno) on delete cascade on update cascade
);

drop table if exists deposit;
create table deposit ( # 결제 테이블
	dno int auto_increment,			# 입금번호
    rno int  ,     					# 라이더번호
    ddate datetime default now(),	# 입금일
    ddeposit int,					# 입금액
	primary key( dno ),
    foreign key( rno) references rider(rno) on delete cascade on update cascade
);

select * from member;
select * from rider;
select * from service;
select * from deposit;
# -------------------------------------------------------- 필드추가 -----------------------------------------------------------------------------------
alter table member add mphoto longtext;
# -------------------------------------------------------- 조작어 -------------------------------------------------------------------------------------

# member 샘플
insert into
	member( mname , mid , mpwd , memail ,  mpayinfo )
    values( '홍길동' , 'qweqwe' , 'qwe1234' , 'qweqwe@naver.com' , '1234-1234' );

insert into
	member( mname , mid , mpwd , memail ,  mpayinfo )
    values( '정희락' , 'qweqww' , 'qwe1234' , 'qweasd@naver.com' , '1234-1234' );


insert into
	member( mname , mid , mpwd , memail ,  mpayinfo )
    values( '박상빈' , 'qweqwa' , 'qwe1234' , 'qweqwa@naver.com' , '1234-1234' );

# rider 샘플

insert into
	rider( rname , rid , rpwd , rphone , rphoto , rlicense ,  rregistration , raccount , rbank )
	values ( '이진형 ' , 'ljh401' , '123123' , '01012341234' , 'default.webp' , 'default.webp' ,'default.webp', '123123-123123' , '국민' );

insert into
	rider( rname , rid , rpwd , rphone , rphoto , rlicense ,  rregistration , raccount , rbank  )
	values ( '황태웅 ' , 'hw0308' , '456789' , '01012341234' , 'default.webp' , 'default.webp' ,'default.webp', '123123-456456' , '국민' );

insert into
	rider( rname , rid , rpwd , rphone , rphoto , rlicense ,  rregistration , raccount , rbank  )
    values ( '김현수 ' , 'itdanja' , '2072' , '01012341234' , 'default.webp' , 'default.webp' ,'default.webp', '123123-207272' , '국민' );

#  라이더 회원가입
insert into
	rider( rname , rid , rpwd , rphone , rphoto , rlicense ,  rregistration , raccount , rbank )
	values ( ? , ? , ? , ? , ? , ? , ? , ? , ? );

# 라이더 로그인
select * from rider where rid = 'itdanja' and rpwd = '2072';
# select * from rider where rid = ? and rpwd = ?


# Member 회원가입
insert into member(mname, mid, mpwd, memail, mpayinfo,mphoto) values (?,?,?,?,?,?);










