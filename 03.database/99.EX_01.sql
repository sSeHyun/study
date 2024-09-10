-- 실습문제(제출)
-- ex01) emp테이블에서 ename, hiredate, 근속년, 근속월, 근속일수 출력, deptno = 10;
-- months_between, round, turnc, 개월수계산(/12), 일수계산(/365, /12)
SELECT ENAME, HIREDATE, (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(HIREDATE,'YYYY')) 근속년, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 근속월,
	TRUNC((SYSDATE - HIREDATE)) 근속일 
	FROM EMP e WHERE DEPTNO = 10;

-- ex02) student에서 birthday중 생일 1월의 학생의 이름과 생일을 출력(YYYY-MM-DD)
SELECT NAME, TO_CHAR(BIRTHDAY, 'YYYY-MM-DD') FROM STUDENT s WHERE TO_CHAR(BIRTHDAY, 'MM') = '01'; 

-- ex03) emp에서 hiredate가 1,2,3월인 사람들의 사번, 이름, 입사일을 출력
SELECT EMPNO, ENAME, HIREDATE FROM EMP  WHERE TO_CHAR(HIREDATE, 'MM') IN ('01','02','03');

-- ex04) emp 테이블을 조회하여 이름이 'ALLEN' 인 사원의 사번과 이름과 연봉을 
--       출력하세요. 단 연봉은 (sal * 12)+comm 로 계산하고 천 단위 구분기호로 표시하세요.
--       7499 ALLEN 1600 300 19,500     
SELECT EMPNO, ENAME, (SAL * 12) + NVL(COMM, 0) 연봉 FROM EMP  WHERE ENAME = 'ALLEN';

-- ex05) professor 테이블을 조회하여 201 번 학과에 근무하는 교수들의 이름과 
--       급여, 보너스, 연봉을 아래와 같이 출력하세요. 단 연봉은 (pay*12)+bonus
--       로 계산합니다.
--       name pay bonus 6,970
SELECT NAME, PAY, NVL(BONUS, 0) BONUS, NVL(PAY, 0) + NVL(BONUS, 0) 연봉 FROM PROFESSOR  WHERE DEPTNO = 201;

-- ex06) emp 테이블을 조회하여 comm 값을 가지고 있는 사람들의 empno , ename , hiredate ,
--       총연봉,15% 인상 후 연봉을 아래 화면처럼 출력하세요. 단 총연봉은 (sal*12)+comm 으로 계산하고 
--       15% 인상한 값은 총연봉의 15% 인상 값입니다.
--      (HIREDATE 컬럼의 날짜 형식과 SAL 컬럼 , 15% UP 컬럼의 $ 표시와 , 기호 나오게 하세요)
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY.MM.DD') 입사일,LTRIM(TO_CHAR((SAL * 12) + COMM,'$999,999'), ' ') 연봉, 
	LTRIM(TO_CHAR(((SAL * 12) + COMM) + ((SAL * 12) + COMM)*0.15, '$999,999'), ' ') 인상
	FROM EMP  WHERE COMM IS NOT NULL;


-- ex07) Professor 테이블에서 201번 학과 교수들의 이름과 급여, bonus , 총 연봉을 출력하세요. 
--       단 총 연봉은 (pay*12+bonus) 로 계산하고 bonus 가 없는 교수는 0으로 계산하세요
SELECT NAME, PAY, NVL(BONUS, 0) BONUS, LTRIM(TO_CHAR(((PAY * 12) + NVL(BONUS, 0)), '$999,999'), ' ') 연봉 FROM PROFESSOR  WHERE DEPTNO = 201;

-- ex08) 아래 화면과 같이 emp 테이블에서 deptno 가 30 번인 사원들을 조회하여 comm 값이 있을 경우
--       'Exist' 을 출력하고 comm 값이 null 일 경우 'NULL' 을 출력하세요 
SELECT ENAME, NVL2(COMM, 'Exist', 'NULL') IsExist FROM EMP  WHERE DEPTNO = 30;
