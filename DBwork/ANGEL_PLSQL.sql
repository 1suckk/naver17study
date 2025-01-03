--PL/SQL이란 SQL 언어에 절차적 언어요소를 추가해서 프로그래밍한 것을 PL/SQL이라고 한다
-- 형식
-- DECLARE
--  변수,커서,선언
-- BEGIN
--  SQL 구문이나 PL/SQL 문으로 코딩
-- END; 
-- /(실행)

--SCRIPT 출력 창에 결과가 나오도록 한번만 설정
SET SERVEROUTPUT ON

-- 예제 1
DECLARE 
    V_NO NUMBER(4, 1); -- 변수 선언, 4자리 수에 소숫점 1자리
BEGIN
    V_NO := 12.7; --오라클은 대입연산자는 콜론 / 비교연산자는 =
    dbms_output.put_line(V_NO); --JAVA의 PRINTLN 함수와 동일
END;
/

--예제 2
DECLARE 
    VCOLOR VARCHAR2(20);
    VPRICE NUMBER(10);
    VSANGPUM VARCHAR2(20);
BEGIN
    VCOLOR := '오렌지색';
    VPRICE := 35000;
    VSANGPUM := '모직코트';
END;
/

--예제 3
DECLARE 
    VSCODE VARCHAR2(20);
    VSPRICE VARCHAR2(10);
    VSANGPUM VARCHAR2(30);
BEGIN
    VSCODE := 'A300';
    
    SELECT SANGPRICE, SANGNAME
    INTO VSPRICE, VSANGPUM
    FROM SHOP
    WHERE SANGCODE=VSCODE;

    dbms_output.put_line('상품명: '||VSANGPUM);
    dbms_output.put_line('가 격: '||VSPRICE||'원');
    dbms_output.put_line('코드번호: '||'VSCODE');
END;
/

--IF문 십이지로 만들기
-- ACCEPT를 이용해서 연도를 스캐너와 같이 직접 입력
ACCEPT YEAR PROMPT '년도를 직접 입력해주세요: ';

DECLARE 
    V_YEAR NUMBER(4) := '&YEAR'; -- 입력받은 년도 가져오기
    V_MOD NUMBER(2) := MOD(V_YEAR, 12); --서기 1년은 닭띠 12년이 원숭이
    V_DDI VARCHAR2(20);
BEGIN
    IF V_MOD = 0 THEN V_DDI:='원숭이띠';
    ELSIF V_MOD = 1 THEN V_DDI:='닭띠';
    ELSIF V_MOD = 2 THEN V_DDI:='개띠';
    ELSIF V_MOD = 3 THEN V_DDI:='돼지띠';
    ELSIF V_MOD = 4 THEN V_DDI:='쥐띠';
    ELSIF V_MOD = 5 THEN V_DDI:='소띠';
    ELSIF V_MOD = 6 THEN V_DDI:='범띠';
    ELSIF V_MOD = 7 THEN V_DDI:='토끼띠';
    ELSIF V_MOD = 8 THEN V_DDI:='용띠';
    ELSIF V_MOD = 9 THEN V_DDI:='뱀띠';
    ELSIF V_MOD = 10 THEN V_DDI:='말띠';
    ELSIF V_MOD = 11 THEN V_DDI:='양띠';
    END IF; -- 종료 ELSIF와 다르게 띄어서 써야 한다
    

    dbms_output.put_line(V_YEAR || '년은 ' || V_DDI || '해이다.');
END;
/

--예제4 상품코드 상품명 가격을 입력하여 SHOP 테이블에 추가하자
ACCEPT SCODE PROMPT 'A로 시작하는 상품코드를 입력하세요.: '; 
ACCEPT SSANG PROMPT '상품명을 입력하세요.: ';
ACCEPT SPRICE PROMPT '가격을 입력하세요.: ';

DECLARE
    V_CODE VARCHAR2(20) := '&SCODE';
    V_SANG VARCHAR2(20) := '&SSNAG';
    V_PRICE NUMBER(10) := '&SPRICE';
BEGIN
    INSERT INTO SHOP (sangcode, sangname, sangprice)
        VALUES (v_code, v_sang, v_price);
    dbms_output.put_line(V_SANG||' 상품정보를 테이블에 추가했습니다.');
END;
/

--예제 5 CURSOR와 FOR문을 이용하여 SHOP의 데이터를 읽어오자(QUERY문)
DECLARE
    CURSOR S1
    IS
    SELECT *
    FROM SHOP
    ORDER BY sangcode;
BEGIN
    FOR S IN S1 LOOP --RECORD 단위로 S가 가져온다
        dbms_output.put_line(S.SANGCODE||'  '||S.SANGNAME||'    '||S.SANGPRICE);
        EXIT WHEN S1%NOTFOUND; -- 더이상 데이터가 없으면 FOR문을 빠져나간다
    END LOOP;
END;
/

--응용: SQL JOIN 문을 이용해서 CARTNUM, SANGCODE, SANGNAME, SANGPRICE, CNTNUM, 
--CNTDAY 출력
DECLARE
    CURSOR S1
    IS
    SELECT CARTNUM, S.SANGCODE, SANGNAME, SANGPRICE, CNTNUM,
           TO_CHAR(C.CNTDAY, 'YYYY-MM-DD HH24:MI') CNTDATE
    FROM SHOP S
    JOIN CART C
        ON s.sangcode = c.sangcode    
    ORDER BY sangcode;
BEGIN
    FOR S IN S1 LOOP --RECORD 단위로 S가 가져온다
        dbms_output.put_line(S.CARTNUM||'  '||S.SANGCODE||'  '||S.SANGNAME||
        '    '||S.SANGPRICE||'  '||S.CNTNUM||'  '||S.CNTDATE);
        EXIT WHEN S1%NOTFOUND; -- 더이상 데이터가 없으면 FOR문을 빠져나간다
    END LOOP;
END;
/

--상품코드와 상품명 상품가격을 입력하여 ACCEPT 이용 입력 후
--SHOP에 해당 상품코드가 존재할 경우 UPDATE로 수정을 하고
--존재하지 않을 경우 INSERT로 추가하시오
ACCEPT SCODE PROMPT 'A로 시작하는 상품코드를 입력하세요.: '; 
ACCEPT SSANG PROMPT '상품명을 입력하세요.: ';
ACCEPT SPRICE PROMPT '가격을 입력하세요.: ';

DECLARE
    V_CODE VARCHAR2(20) := '&SCODE';
    V_SANG VARCHAR2(20) := '&SSANG';
    V_PRICE NUMBER(10) := '&SPRICE';
    V_COUNT NUMBER;
BEGIN
    SELECT COUNT(*) INTO V_COUNT
    FROM SHOP
    WHERE sangcode = v_code;
    
    IF V_COUNT > 0 
        THEN
            UPDATE SHOP
            SET SANGNAME = V_SANG, SANGPRICE = V_PRICE
            WHERE SANGCODE = V_CODE;
            dbms_output.put_line(V_SANG||'상품정보를 테이블에 수정했습니다.');
    ELSE
        INSERT INTO SHOP (SANGCODE, SANGNAME, SANGPRICE)
        VALUES (V_CODE, V_SANG, V_PRICE);
        dbms_output.put_line(V_SANG||'상품정보를 테이블에 추가했습니다.');
    END IF;
    COMMIT;
EXCEPTION
    WHEN OTHERS 
        THEN 
            dbms_output.put_line('오류 발생: '||SQLERRM);
            ROLLBACK;
END;
/

--상품명을 입력하면 SHOP 테이블에서 그 이름을 포함하고 있는 데이터들을 모두 출력
-- 커서를 사용할 것
ACCEPT SSANG PROMPT '상품명을 입력하세요.: ';

DECLARE
    V_SANG VARCHAR2(20) := '%' || '&SSANG' || '%';
    
    -- 커서 선언
    CURSOR SHOP_CURSOR
    IS 
    SELECT SANGCODE, SANGNAME, SANGPRICE
    FROM SHOP
    WHERE SANGNAME LIKE V_SANG;
    V_FOUND BOOLEAN := FALSE;

BEGIN
    dbms_output.put_line('검색 결과: ');
    dbms_output.put_line('상품코드 | 상품명 | 상품가격');
    
    FOR SC IN SHOP_CURSOR LOOP
        dbms_output.put_line(SC.SANGCODE||' | '||SC.SANGNAME||' | '||
                             SC.SANGPRICE);
        V_FOUND := TRUE;
    END LOOP;
    
    IF NOT V_FOUND THEN
            dbms_output.put_line('&SSANG'||' 상품의 이름이 없습니다.');
    END IF;
    
EXCEPTION
    WHEN OTHERS THEN 
            dbms_output.put_line('오류 발생: '||SQLERRM);
            
END;
/