-- 전체 테이블 확인하기
-- study502에서 실행
show tables; -- 없음

-- 현재 날짜와 시간 구하기 (여러가지 방법이 있지만 now()가 제일 편함)
select now()
from dual;
select sysdate()
from dual;
select current_timestamp()
from dual;

-- 날짜함수들
select year(now())
from dual; -- 2025
select month(now())
from dual; -- 1
select day(now())
from dual; -- 일만 나옮
select date(now())
from dual; -- '%Y-%m-%d' 
select monthname(now())
from dual; -- 영어로 월이 나옮 january
select dayname(now())
from dual; -- 영어로 요일이 나옮 thursday

-- date_format(날짜, '형식') -> 오라클의 to_char() 와 같다
-- %Y(4자리 연도), %M(월을 영어로), %d(날짜)
select date_format(now(), '%Y-%M-%d')
from dual; -- 2025-January-02

select date_format(now(), '%y-%m-%d')
from dual; -- 25-01-02

-- %H : 24시간, %h : 12시간 표시 %i : 분
select date_format(now(), '%Y-%m-%d %H:%i')
from dual; -- 2025-01-02 15:03

select date_format(now(), '%Y년%m월%d일 %H시%i분')
from dual; -- 2025-01-02 15:03

-- 문자 함수들
-- concat(a, b) : 문자열 결합, 여러 개도 가능하다 (오라클은 2개만 가능)
select concat('happy ', 'day')
from dual;
select concat('happy ', 'day! ', 'Maam')
from dual;
-- replace 문자열을 대체
select replace('bitcamp', 'bit', '비트')
from dual;
-- instr('문자열', '찾는문자열'):위치 반환
select instr('김영희', '영희')
from dual; -- 2번째에 있다는 뜻
select instr('김영희', '철수')
from dual; -- 0 (0은 없다는 뜻)

-- left('문자열', 갯수) : 왼쪽에서 추출
-- mid('문자열', 갯수) : 중간에서 추출
-- right('문자열', 갯수) : 오른쪽에서 추출
-- substring('문자열', 시작위치, 갯수): 시작위치부터 갯수만큼 추출
select left('Have a nice day', 4)
from dual; -- Have
select mid('Have a nice day', 3)
from dual; -- day
select substring('Have a nice day', 8, 4)
from dual; -- nice

-- ltrim, rtrim, trim 공백 제거
select (concat('_', ltrim('   Happy    '), '_'))
from dual;
select (concat('_', rtrim('   Happy    '), '_'))
from dual;
select (concat('_', trim('   Happy    '), '_'))
from dual;

-- upper/ucase, lower/lcase, reverse
select lower('HappY DaY HanA')
from dual;
select lcase('HappY DaY HanA')
from dual;
select upper('HappY DaY HanA')
from dual;
select ucase('HappY DaY HanA')
from dual;
select reverse('HappY DaY HanA')
from dual;

-- 조건 함수
-- if(조건식, 참일때값, 거짓일때값)
select if(100>200, 'true', 'false')
from dual;
select if(100>200, 'true', 'false') result -- column 제목 변경
from dual;

-- ifnull(컬럼값, 널일때의 대치값) <-> nvl
select ifnull(null,1)
from dual;
select ifnull('mija',1)
from dual;

-- 숫자함수
-- abs(), ceiling(), floor()
select
	abs(6) '절댓값', ceiling(3.1) '올림',
    floor(3.1) '내림', round(3.16, 1) '반올림',
    round(567892, -2) '십의 자리에서 반올림'
from dual;

-- pow : 지수승, mod : 나머지 
select pow(2,3), mod(10, 3)
from dual;

-- greatest(num1, num2, ...) : 가장 큰 숫자 구하기
-- least(num1, num2, ...) : 가장 작은 숫자 구하기
select greatest(100, 110, 120, 130), least(100, 110, 120, 130)
from dual;



