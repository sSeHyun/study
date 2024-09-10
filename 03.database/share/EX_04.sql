/* update 연습문제 */
-- 실습1)  emp999에서 모든 사원의 급여를 10%인상하기(수정)
SELECT * FROM EMP999;
UPDATE EMP999 
	SET SAL = SAL*1.1;

-- 실습2) emp999에서 모든 사원의 입사일을 현재일(sysdate)로 수정
UPDATE EMP999 
	SET HIREDATE = SYSDATE;

-- 실습3) professor에서 직급이 'assistant professor'인 사람의 bonus를 200으로 인상
SELECT * FROM PROFESSOR p WHERE "POSITION" = 'assistant professor';
UPDATE PROFESSOR 
	SET BONUS = 200
	WHERE "POSITION" = 'assistant professor';


-- 실습4) professor에서 'Sharon Stone'과 직급이 동일한 교수들의 급여를 15%인상
--        서브쿼리를 이용 -> where절에 서브쿼리를 지정
--                        -> where position = (서브쿼리 즉, select문을 정의)
SELECT "POSITION" FROM PROFESSOR p WHERE NAME = 'Sharon Stone';
SELECT * FROM PROFESSOR p WHERE "POSITION" = 'instructor';
UPDATE PROFESSOR 
	SET PAY = PAY * 1.15
	WHERE "POSITION" = (SELECT "POSITION" 
						FROM PROFESSOR p 
						WHERE NAME = 'Sharon Stone');

-- ex01) job이 'MANAGER'인 사원은 급여를 15%인상하기
SELECT * FROM EMP e WHERE JOB = 'MANAGER';
UPDATE EMP 
	SET SAL = SAL * 1.15
	WHERE JOB = 'MANAGER';

-- ex02) SCOTT 사원의 부서번호=30번, JOB=MANAGER로 한꺼번에 수정하는 쿼리
SELECT * FROM EMP e WHERE ENAME = 'SCOTT';
UPDATE EMP 
	SET DEPTNO = 30,
		JOB = 'MANAGER'
	WHERE ENAME = 'SCOTT';

-- ex03) professor테이블에서 'Sharon Stone'교수의 bonus를 100만원으로 인상하기
SELECT * FROM PROFESSOR p WHERE NAME = 'Sharon Stone';
UPDATE PROFESSOR 
	SET BONUS = 100
	WHERE NAME = 'Sharon Stone';

-- ex04) professor에서 'Sharon Stone'교수의 직급과 동일한 직급을 가진 교수들중
-- 현재급여가 250이 안되는 교수들의 급여를 15%인상하세요!
SELECT * FROM PROFESSOR p WHERE NAME = 'Sharon Stone';
SELECT * FROM PROFESSOR p WHERE P."POSITION" = (SELECT TMP."POSITION" FROM PROFESSOR TMP WHERE NAME = 'Sharon Stone');
						  AND P.PAY < 250
						  
UPDATE PROFESSOR 
	SET PAY = PAY * 1.15
	WHERE "POSITION" = (SELECT TMP."POSITION" FROM PROFESSOR TMP WHERE NAME = 'Sharon Stone')
	AND PAY < 250;

