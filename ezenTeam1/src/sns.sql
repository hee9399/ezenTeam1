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

# 1. 호출 
insert into sns(sfile,scontent,spwd) values('default.webp','하이','1234');
insert into sns(sfile,scontent,spwd) values('default.webp','이하','12345');
insert into sns(sfile,scontent,spwd) values('default.webp','이리','123467');
insert into sns(sfile,scontent,spwd) values('default.webp','지비','123486');


select * from sns;

# 2. 수정 
update sns set sfile = 'efault.webp' , scontent = '안녕' , spwd = '1234' where sno = 1;
-- update sns set sfile = ? , scontent = ? , spwd = ? where sno = ?

# # 3. 개별 글 출력 [  게시물 조회 ]
select * from sns where sno = ?;

# 삭제 
delete from sns where sno = 1 and spwd = '1234';
-- delete from sns where sno = ? and spwd = ?