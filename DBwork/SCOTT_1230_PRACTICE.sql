--PRACTICE FOR ORACLE FINAL SQL IN 20241230
------------------------------------------------
--1. EMP 테이블에서 어던 종류의 직업이 있는지 JOB을 한번씩만
--출력하는데 직업의 오름차순으로 출력하시오
------------------------------------------------
SELECT DISTINCT JOB
FROM EMP
ORDER BY JOB ASC;
------------------------------------------------
--2. ENAME에 대소문자 상관없이 'S'를 포함하고 있는
--데이터출력(컬럼:ENAME, JOB, SAL)
------------------------------------------------
SELECT ENAME, JOB, SAL
FROM EMP
WHERE LOWER(ENAME) LIKE '%s%';
------------------------------------------------
--3. ENAME의 3번재 글자가 L인 사람을 조회하시오
--(컬럼:ENAME, SAL, COMM)
------------------------------------------------
SELECT ENAME, SAL, COMM
FROM EMP
WHERE ENAME LIKE '__L%';
------------------------------------------------
--4. COMM이 NULL이 아닌 사람 중에 SAL이 1500 이상인
--사람 출력 (컬럼:ENAME, HIREDATE, SAL)
------------------------------------------------
SELECT ENAME, HIREDATE, SAL
FROM EMP
WHERE COMM IS NOT NULL 
    AND SAL >= 1500;
------------------------------------------------
--5. HIREDATE 입사일이 5월인 사람은 모두 출력(컬럼:ENAME, HIREDATE, SAL)
------------------------------------------------
SELECT ENAME, HIREDATE, SAL
FROM EMP
WHERE TO_CHAR(HIREDATE, 'MM') = 05;
------------------------------------------------
--6. hiredate 입사일이 1985-01-01 이후에 입사한사람 출력(컬럼: ename,hiredate,sal)
------------------------------------------------
SELECT ENAME, HIREDATE, SAL
FROM EMP
WHERE HIREDATE >= TO_DATE('1985-01-01')
ORDER BY HIREDATE;
------------------------------------------------
--7. sal이 1500-3000 사이인 사람을 출력하는데 관계연산자와 and를 이용해서 출력
------------------------------------------------
SELECT *
FROM EMP
WHERE SAL >= 1500 AND SAL <= 3000
ORDER BY SAL;
------------------------------------------------
--8. 7번의 결과를 between 을 이용해서 출력(컬럼:ename,sal,mgr)
------------------------------------------------
SELECT ENAME, SAL, MGR
FROM EMP
WHERE SAL BETWEEN 1500 AND 3000
ORDER BY SAL;
------------------------------------------------
--09. in을 이용해서 job 이 clerk,president,manager 인 사람의 전체 컬럼을 모두 출력
------------------------------------------------
SELECT *
FROM EMP
WHERE JOB IN ('CLERK', 'PRESIDENT', 'MANAGER')
ORDER BY JOB ASC;
------------------------------------------------
--10. ename,sal,comm,sal*comm 을 출력하는데 comm 이 null 인경우
--1로 변경해서 출력하고 계산하기
------------------------------------------------
SELECT ENAME, SAL, COMM, NVL(SAL*COMM, 1)
FROM EMP;
------------------------------------------------
--11. ename 이 ADAMS인 사람의 SAL보다 더 많이 받는사람출력(컬럼명:ENAME,JOB,SAL)
------------------------------------------------
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL > (
    SELECT SAL
    FROM EMP
    WHERE ENAME = 'ADAMS'
);
------------------------------------------------
--12. 평균SAL 보다 작은 사람의 전체 컬럼 출력
------------------------------------------------
SELECT *
FROM EMP
WHERE SAL < (
    SELECT AVG(SAL)
    FROM EMP
);
------------------------------------------------
--13. ENAME 이 A나 S나 M으로 시작하는 모든 사람 출력(컬럼:ENAME,JOB,SAL)
------------------------------------------------
SELECT ENAME, JOB, SAL
FROM EMP
WHERE ENAME LIKE 'A%'
    OR ENAME LIKE 'S%'
    OR ENAME LIKE 'M%';
------------------------------------------------
--14. MGR 을 GROUP 로 인원수와 평균SAL 을 구하시오(평균SAL은 무조건 올림으로)
------------------------------------------------
SELECT MGR, COUNT(*) 인원수, CEIL(AVG(SAL)) 평균월급여
FROM EMP
GROUP BY MGR
ORDER BY MGR;

SELECT MGR, COUNT(*) 인원수, ROUND(AVG(SAL), -1) 평균월급여
FROM EMP
GROUP BY MGR
ORDER BY MGR;

SELECT MGR, COUNT(*) 인원수, ROUND(CEIL(AVG(SAL)),-1) 평균월급여
FROM EMP
GROUP BY MGR
ORDER BY MGR;
------------------------------------------------
--15. SCOTT의 월급여와 같은 월급여를 받는 사람들을 출력 (컬럼: ENAME, SAL)
------------------------------------------------
SELECT ENAME, SAL
FROM EMP
WHERE SAL =
(
    SELECT SAL 
    FROM EMP
    WHERE ENAME = 'SCOTT'
);
------------------------------------------------
--15. SCOTT의 월급여와 같은 월급여를 받는 사람들을 출력 (컬럼: ENAME, SAL)
------------------------------------------------
SELECT ENAME, SAL
FROM EMP
WHERE SAL =
(
    SELECT SAL 
    FROM EMP
    WHERE ENAME = 'SCOTT'
);

--SCOTT 본인은 제외해서 출력
SELECT ENAME, SAL
FROM EMP
WHERE SAL =
(
    SELECT SAL 
    FROM EMP
    WHERE ENAME = 'SCOTT'
)
    AND ENAME != 'SCOTT';
------------------------------------------------
--16. ENAME 의 글자길이가 4글자인 사람만 조회(컬럼:ENAME,JOB)
------------------------------------------------
SELECT ENAME, JOB
FROM EMP
WHERE LENGTH(ENAME) = 4;
------------------------------------------------
--17.  ENAME의 3번째 글자가 R이거나 A인사람 조회(컬럼:ENAME,JOB)
------------------------------------------------
SELECT ENAME, JOB
FROM EMP
WHERE ENAME LIKE '__R%'
    OR ENAME LIKE '__A%';
------------------------------------------------
--18. 직군별로 인원수와 최고연봉을 출력하는데 직업의 오름차순으로 출력
------------------------------------------------
SELECT JOB 직업, COUNT(*) 인원수, MAX(SAL) 직군별최고급여
FROM EMP
GROUP BY JOB
ORDER BY JOB ASC;
------------------------------------------------
--19. || 연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오(EMP테이블로)
--(예) SCOTT 의 직업은 CLERK 이며 입사년도는 1989년 05월입니다(컬럼명은 자기소개
------------------------------------------------
SELECT ENAME||'의 직업은 '||JOB||'이며 입사년도는 '||TO_CHAR(HIREDATE, 'YYYY')
||'년 '||TO_CHAR(HIREDATE, 'MM')||'월입니다.' 자기소개
FROM EMP;