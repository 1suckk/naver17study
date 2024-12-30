-- emp 테이블로 연습
select distinct job from emp;
select ename, job
from emp
order by ename desc;

-- job의 오름차순, 같은 job인 경우에는 ename의 내림차순 조회
select job, ename 
FROM emp
order by job, ename desc;

-- job의 오름차순, 같은 job인 경우에는 ename도 오름차순 조회
select job, ename 
FROM emp
order by job, ename;

--순서를 정할 때 컬럼명 대신 컬럼번호로 해도 된다
select job, ename 
FROM emp
order by 1,2;

-- sal을 오름차순으로 정렬
select *
from emp
order by 6;

-- where 조건문
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE SAL>=1500;

--데이터는 스키마와 다르게 
-- 대소문자를 맞춰줘야 한다
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME = 'ALLEN'; -- 'ALLEN'이라고 하면 안됨

-- ENAME이 A로 시작하는 데이터 조회
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME LIKE 'A%';

-- ENAME에 A가 포함되는 데이터 조회
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME LIKE '%A%';

SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME LIKE ('A%') OR ENAME LIKE ('S%');

--ENAME에 A와 S를 모두 포함하는 데이터 조회
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME LIKE ('%A%') AND ENAME LIKE ('%S%');

-- ENAME에 두번째 글자가 A가 포함되는 데이터 조회
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME LIKE '_A%';

-- ENAME에 두번째 글자 혹은 세번째 글자가 A가 포함되면서 이름은 내림차순으로 정렬한
-- 데이터 조회
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME
LIKE '_A%' OR ENAME LIKE '__A%'
ORDER BY ENAME DESC;

SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE ENAME LIKE '%N' OR ENAME LIKE '%K';

-- JOB이 ANALYST이면서 SAL이 1500 이상인 사람 조회
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE JOB = 'ANALYST' AND SAL >= 1500;

-- SAL 1200 ~ 2000 사이값 조회
SELECT ENAME, JOB, SAL, COMM 
FROM EMP
WHERE SAL BETWEEN 1200 AND 2000;

-- JOB이 MANAGER이거나 SALESMAN이거나 ANALYST인 직업의 사람을 조회
SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE JOB = 'MANAGER'
    OR JOB = 'SALESMAN'
    OR JOB = 'ANALYST';

SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE JOB
    IN ('MANAGER', 'SALESMAN', 'ANALYST');
    
SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE EMPNO
    IN (7654, 7788, 7844, 7902);
    
--COMM이 NULL인 데이터만 조회
SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE COMM IS NULL;

SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE COMM IS NOT NULL;

-- MGR이 NULL이 아닌 값을 찾아라
SELECT * 
FROM EMP
WHERE MGR IS NOT NULL;

-- COMM이 NULL인 경우는 0으로 출력, MGR이 NULL인 경우는 100으로 출력
SELECT ENAME, JOB, SAL, NVL(MGR,100), NVL(COMM, 0)
FROM EMP;

-- NUMBER와 NULL을 더하면 NULL이 나온다
SELECT SAL, COMM, NVL(SAL+COMM, 0)
FROM EMP;