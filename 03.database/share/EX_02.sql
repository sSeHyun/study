
/* 연습문제 */
-- 1. emp 테이블을 사용하여 사원 중에서 급여(sal)와 보너스(comm)를 합친 금액이 가장 많은 경우와 
--    가장 적은 경우 , 평균 금액을 구하세요. 단 보너스가 없을 경우는 보너스를 0 으로 계산하고 
--    출력 금액은 모두 소수점 첫째 자리까지만 나오게 하세요
-- MAX, MIN, AVG
SELECT MIN(SAL + NVL(COMM, 0)), MAX(SAL + NVL(COMM, 0)), ROUND(AVG(SAL + NVL(COMM, 0)), 1)  
FROM EMP e;

-- 2. student 테이블의 birthday 컬럼을 참조해서 월별로 생일자수를 출력하세요
-- TOTAL, JAN, ...,  5 DEC
--  20EA   3EA ....
SELECT  CASE TO_CHAR(BIRTHDAY, 'MM')
		WHEN '01' THEN 'JAN'
		WHEN '02' THEN 'FEB'
		WHEN '03' THEN 'MAR'
		WHEN '04' THEN 'APR'
		WHEN '05' THEN 'MAY'
		WHEN '06' THEN 'JUN'
		WHEN '07' THEN 'JAL'
		WHEN '08' THEN 'AUG'
		WHEN '09' THEN 'SEP'
		WHEN '10' THEN 'OCT'
		WHEN '11' THEN 'NOV'
		WHEN '12' THEN 'DEC'
		END AS 월,
		COUNT(*) 
FROM STUDENT s 
GROUP BY ROLLUP(TO_CHAR(BIRTHDAY, 'MM')) 
ORDER BY TO_CHAR(BIRTHDAY, 'MM');

-- 3. Student 테이블의 tel 컬럼을 참고하여 아래와 같이 지역별 인원수를 출력하세요.
--    단, 02-SEOUL, 031-GYEONGGI, 051-BUSAN, 052-ULSAN, 053-DAEGU, 055-GYEONGNAM
--    으로 출력하세요
SELECT CASE SUBSTR(TEL, 1, INSTR(TEL, ')', 1) - 1)
			WHEN '02' THEN '서울'
			WHEN '031' THEN '경기'
			WHEN '051' THEN '부산'
			WHEN '052' THEN '울산'
			WHEN '053' THEN '대구'
			WHEN '055' THEN '경남'
			ELSE '기타'
			END 지번,
			COUNT(*) 
FROM STUDENT s 
GROUP BY SUBSTR(TEL, 1, INSTR(TEL, ')', 1) - 1)
ORDER BY SUBSTR(TEL, 1, INSTR(TEL, ')', 1) - 1);

-- 4. emp 테이블을 사용하여 직원들의 급여와 전체 급여의 누적 급여금액을 출력,
-- 단 급여를 오름차순으로 정렬해서 출력하세요.
-- sum() over()
SELECT ENAME,
	   SAL,
	   NVL(COMM, 0),
	   SUM(SAL + NVL(COMM, 0)) OVER(ORDER BY SAL) 
FROM EMP e ;

-- 6. student 테이블의 Tel 컬럼을 사용하여 아래와 같이 지역별 인원수와 전체대비 차지하는 비율을 
--    출력하세요.(단, 02-SEOUL, 031-GYEONGGI, 051-BUSAN, 052-ULSAN, 053-DAEGU,055-GYEONGNAM)
SELECT  SUBSTR(TEL, 1, INSTR(TEL, ')', 1) - 1),
		RATIO_TO_REPORT(SUM((SUBSTR(TEL, 1, INSTR(TEL, ')', 1) - 1)))) OVER()
FROM STUDENT s
GROUP BY SUBSTR(TEL, 1, INSTR(TEL, ')', 1) - 1);

-- 7. emp 테이블을 사용하여 부서별로 급여 누적 합계가 나오도록 출력하세요. 
-- ( 단 부서번호로 오름차순 출력하세요. )
SELECT DISTINCT DEPTNO,
	   SUM(SAL + NVL(COMM, 0)) OVER(ORDER BY DEPTNO) "누적 합계"
FROM EMP e ;

-- 8. emp 테이블을 사용하여 각 사원의 급여액이 전체 직원 급여총액에서 몇 %의 비율을 
--    차지하는지 출력하세요. 단 급여 비중이 높은 사람이 먼저 출력되도록 하세요
SELECT ENAME,
	   RATIO_TO_REPORT(SAL + NVL(COMM, 0)) OVER() 비율 
FROM EMP e 
ORDER BY 2 DESC;


-- 9. emp 테이블을 조회하여 각 직원들의 급여가 해당 부서 합계금액에서 몇 %의 비중을
--     차지하는지를 출력하세요. 단 부서번호를 기준으로 오름차순으로 출력하세요.
SELECT ENAME,
	   DEPTNO,
	   SUM(SAL + NVL(COMM, 0)) OVER(ORDER BY DEPTNO) "누적 합계",
	   RATIO_TO_REPORT(SAL + NVL(COMM, 0)) OVER(PARTITION BY DEPTNO) 비율 
FROM EMP e ;
