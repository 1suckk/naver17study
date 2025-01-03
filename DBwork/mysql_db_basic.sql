-- cmd 창에서 접속시
-- mysql -u root -p 엔터 후 비번 입력
show databases;
-- 연습용 데이터베이스 study502 생성
create database study502;
-- cmd 창에서 접속한 경우 use database 명령으로 입력한다

-- database 제거
-- 생성 후 제거해보자
create database test; -- 생성
show databases; -- 확인
drop database test; -- 제거

show databases;