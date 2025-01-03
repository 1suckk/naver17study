 -- 데이타타입
   -- 문자 : char,varchar
--    숫자 :  tinyint  1 byte
--           smallint  2byte
--           mediumint 3byte
--           int       4byte
--           bigint    8byte
--           float     실수타입 4byte
--           double      "      8byte
--           decimal(m,n) : m자리수,n소숫점자릿수
-- 	날짜 :    date   CCYY-MM-DD  :now() 로 저장한다해도 날짜만 저장된다
--           datetime   CCYY-MM-DD hh:mm:ss : now() 로 저장하면 날짜와 시간이저장된다
--           timestamp     "
--           time          hh:mm:ss
--           year        CCYY 또는 YY

create table person(
	num smallint auto_increment primary key,
	name varchar(20),
    blood varchar(10) default 'B',
    age smallint,
    today date,
    writeday datetime
);

-- table 구조 확인
desc person;
show create table person; -- 디테일하게 구조확인

-- 데이터 추가하기
insert into person (name, age, today, writeday)
values ('이영자', 23, now(), now());

select *
from person;

insert into person
values (null, '강호동', 'AB', 45, now(), now());

select *
from person;

insert into person
values (null, '유재석', 'O', 19, now(), now());
insert into person
values (null, '고릴라', 'A', 22, now(), now());
insert into person
values (null, '이효리', 'AB', 39, now(), now());
insert into person
values (null, '손진아', 'B', 29, now(), now());

select *
from person;

select num, name, age 
from person
order by age asc;

select num, name, age 
from person
order by age desc;

select *
from person
where age >= 20
	and age < 30;
    
select *
from person
where age
	between 20
	and 30;
    
select count(*)
from person;

select round(avg(age))
from person;

select max(age), min(age)
from person;

select blood, count(*), round(avg(age), 1)
from person;

select blood, count(*)
from person
group by blood;


-- 게시판에서 페이징하는 방법
-- limit
-- 	   첫번째 파라미터 : 시작(0부터)
--     두번째 파라미터 : 가져올 레코드 개수
select *
from person
limit 0,3;

select *
from person
limit 2,3; 

-- where 조건과 limit 동반 사용 시
select *
from person
where age >= 20
limit 1,2;

-- update 
update person
set blood = 'O', age = '18'
where name = '고릴라';

-- Edit > Preferences > SQL Editor로 이동
-- 업뎃 변경 방지 해제해 줘야함 (자동 커밋 활성화)
-- 처음에만 한 번 해주면 된다
select *
from person;