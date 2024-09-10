/* 연습문제 */
-- ex01) student, department에서 학생이름, 학과번호, 1전공학과명출력
SELECT S.NAME , S.DEPTNO1 , D.DEPTNO , D.DNAME 
	FROM STUDENT s , DEPARTMENT d 
	WHERE S.DEPTNO1 = D.DEPTNO ;

-- ex02) emp2, p_grade에서 현재 직급의 사원명, 직급, 현재 년봉, 해당직급의 하한
--       상한금액 출력 (천단위 ,로 구분)   
SELECT E.NAME ,E."POSITION" ,E.PAY ,PG.S_PAY ,PG.E_PAY 
	FROM EMP2 e, P_GRADE pg
	WHERE E."POSITION" = PG."POSITION" ;


-- ex03) emp2, p_grade에서 사원명, 나이, 직급, 예상직급(나이로 계산후 해당 나이의
--       직급), 나이는 오늘날자기준 trunc로 소수점이하 절삭
SELECT E.NAME , TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(E.BIRTHDAY, 'YYYY') AGE, E."POSITION" , PG."POSITION" 
	FROM EMP2 e , P_GRADE pg 
	WHERE TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(E.BIRTHDAY, 'YYYY') BETWEEN PG.S_AGE AND PG.E_AGE ;

-- ex04) customer, gift 고객포인트보나 낮은 포인트의 상품중에 Notebook을 선택할
--       수 있는 고객명, 포인트, 상품명을 출력      
SELECT C.GNAME ,C.POINT ,G.GNAME 
	FROM CUSTOMER c , GIFT g 
	WHERE C.POINT BETWEEN G.G_START AND G.G_END 
	AND C.POINT >= (SELECT G2.G_START FROM GIFT g2 WHERE G2.GNO = 7);

	
-- ex05) professor에서 교수번호, 교수명, 입사일, 자신보다 빠른 사람의 인원수
--       단, 입사일이 빠른 사람수를 오름차순으로
SELECT P.PROFNO, P.NAME, P.HIREDATE, (SELECT COUNT(*) FROM PROFESSOR p2 WHERE P2.HIREDATE > P.HIREDATE) AS 인원
	FROM PROFESSOR p
	ORDER BY HIREDATE ;
	

-- ex06) emp에서 사원번호, 사원명, 입사일 자신보다 먼저 입사한 인원수를 출력
--       단, 입사일이 빠른 사람수를 오름차순 정렬
SELECT E.EMPNO , E.ENAME , E.HIREDATE, (SELECT COUNT(*) FROM EMP e2 WHERE E2.HIREDATE > E.HIREDATE) AS 인원
	FROM EMP e
	ORDER BY HIREDATE ;