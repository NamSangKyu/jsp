drop table member cascade constraint;

--아이디 - 25글자, 암호 - 50글자, 이름 - 10글자, 나이 - 숫자
create table member(
	id varchar2(25 byte) primary key,
	pass varchar2(50 byte) not null,
	name varchar2(30 byte),
	age number
);

alter table member add grade number default 1;

select * from nls_database_parameters where parameter like '%CHARACTERSET%';

select * from member;
delete from member;
insert into member values('A0001', '1234', '홍길동',33,1);
UPDATE MEMBER SET GRADE = 0 WHERE ID = 'admin';
--회원 등급 나타내는 테이블 GRADE_LIST
-- BRONZE - 1, SILVER - 2, GOLD - 3, VIP - 4, VVIP - 5 MASTER -> 0  
create table grade_list(
	grade_no number primary key,
	grade_name varchar2(10 byte)
);
insert into GRADE_LIST values(1, 'BRONZE');
insert into GRADE_LIST values(2, 'SILVER');
insert into GRADE_LIST values(3, 'GOLD');
insert into GRADE_LIST values(4, 'VIP');
insert into GRADE_LIST values(5, 'VVIP');
insert into GRADE_LIST values(0, 'MASTER');

select * from grade_list;

select id, name, pass, age, grade_name from MEMBER, grade_list where grade_no = grade;


create table qna(
		qno number primary key,
		title varchar2(100 byte),
		content varchar2(4000 byte),
		wdate date default sysdate,
		writer varchar2(25 byte),
		status number default 0 , --않읽음 - 0, 읽음 - 1, 답변완료 - 2
		response varchar2(4000 byte)
	);

create sequence qno_seq start with 1;

delete from qna where writer = 'admin' or writer is null;

select * from qna where writer = 'A0001' order by qno desc;
update qna set writer = 'A0001'
select * from 
(select ceil(rownum / 5) as page, qno, title, content, wdate, writer, status, response
from (select * from qna where writer = 'A0001' order by qno desc)) where page = 1;

select * from 
(select ceil(rownum / 5) as page, qno, title, content, wdate, writer, status, response
from (select * from qna order by status asc, qno desc)) where page = 1;



select * from employee where eno = 'AA11';
select * from employee_salary;
alter table employee_salary drop constraint FK_SALARY_ENO;
alter table employee_salary add constraint FK_SALARY_ENO FOREIGN KEY(eno) references employee(eno) on delete cascade; 
delete from employee;
delete from employee_salary where eno in( select eno from employee);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('TQ98','강병헌','영업',4);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('XF41','김동수','회계',7);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('IR45','김시우','영업',6);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('GY76','김준래','법무',7);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('KB74','박셩우','총무',5);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('XD59','박병상','영업',7);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('WH43','박정현','인사',2);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('BM81','서민우','인사',6);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('DA43','이동희','인사',4);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('HM80','이원구','영업',1);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('DI93','정성수','마케팅',4);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('LY86','정희우','마케팅',6);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('IP68','조성수','영업',7);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('PW50','주지우','마케팅',4);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('VS12','최승수','영업',6);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('ZV72','한상오','영업',5);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('JA99','이지원','회계',1);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('MR62','김희연','영업',5);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('SJ41','노소정','법무',6);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('HG13','손지해','총무',5);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('OH20','정다혜','영업',4);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('NM11','장세이','인사',5);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('ZT62','차영연','인사',6);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('TO73','장희은','인사',2);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('JE10','남혜미','영업',5);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('PU91','유민주','마케팅',2);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('QQ84','원소은','마케팅',4);
Insert into EMPLOYEE (ENO,NAME,DEPARTMENT,POSITION) values ('AB11','홍길동','총무',8);


Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('TQ98',6200);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('XF41',3600);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('IR45',7200);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('GY76',4500);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('KB74',2800);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('XD59',2900);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('WH43',3450);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('BM81',14000);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('DA43',5500);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('HM80',5600);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('DI93',8700);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('LY86',6900);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('IP68',3600);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('PW50',12000);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('VS12',4500);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('ZV72',4900);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('JA99',7400);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('MR62',5100);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('SJ41',6000);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('HG13',9900);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('OH20',9600);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('NM11',5900);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('ZT62',4600);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('TO73',4800);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('JE10',7800);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('PU91',7700);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('QQ84',9000);
Insert into EMPLOYEE_SALARY (ENO,SALARY) values ('AB11',3600);


