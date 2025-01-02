-- equi join 혹은 inner join : 두 테이블의 결합
SELECT E.ENAME, E.JOB, E.SAL, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO;

--조인할 테이블에 컬럼명이 겹치지 않은 경우는 테이블명이나 별칭이 붙지 않아도 된다
SELECT E.DEPTNO ENAME, JOB, SAL, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO;

--DECODE 함수 다중 IF문
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, '홍보부', 20, '교육부', 30, '인사부') 부서명
FROM EMP;

