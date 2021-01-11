--게시판 테이블(BOARD)
create table board(
    bno number primary key,
    title varchar2(150 byte),
    bdate date default sysdate,
    bcount number default 0,
    writer varchar2(25 byte),
    content varchar2(500 byte),
    blike number default 0,
    bhate number default 0,
    constraint fk_writer foreign key(writer) references member(id)
);
alter table board add constraint fk_writer foreign key(writer) references member(id);
--댓글
create table board_comment(
    cno number primary key,
    bno number,
    content varchar2(1500 byte),
    cdate date default sysdate,
    writer varchar2(25 byte),
    blike number default 0,
    bhate number default 0,
    constraint fk_comment_writer foreign key(writer) references member(id),
    constraint fk_comment_bno foreign key(bno) references board(bno)
);
--게시판 시퀸스
create sequence bno_seq start with 1 NOMAXVALUE;
--댓글 시퀸스
create sequence cno_seq start with 1 NOMAXVALUE;


--게시판 글목록
select * from board;
select sysdate from dual;
alter session set time_zone = 'Asia/Seoul';


select * from board_comment;

--게시글 목록
select b.*, nvl(c.comment_count,0) 
from board b, (select bno, count(*) as comment_count from board_comment group by bno) c
where b.bno = c.bno(+);
--게시글별 댓글 개수
select bno, count(*) from board_comment group by bno;









