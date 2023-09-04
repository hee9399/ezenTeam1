use jspweb;
drop table if exists sns;
create table sns(
    sno int auto_increment ,                      -- 식별번호( 게시물번호 ) , 자동번호 부여
    sfile text not null ,                       -- ( 사진파일 ) , 공백불가능 ,
    scontent longtext not null  ,              -- ( sns내용 ) , 공백불가능 중복불가
	spwd varchar(20) not null,              -- ( 비밀번호 ) , 공백불가능
    sdate datetime default now() not null,      -- ( 등록일 )  , 공백불가능
    primary key( sno )
);
insert into sns(sfile,scontent,spwd) values('default.webp','하이','1234');
insert into sns(sfile,scontent,spwd) values('default.webp','이하','12345');
insert into sns(sfile,scontent,spwd) values('default.webp','이리','123467');
insert into sns(sfile,scontent,spwd) values('default.webp','지비','123486');
select * from sns;