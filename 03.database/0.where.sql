/*
   A. where 조건절
   
   1. 비교연산자
 
      =, 
      !=, <>
      >
      >=
      <
      <=
      
   2. 기타연산자
      a and b: 논리곱
      a or b : 논리합
      not a  : 부정 
      between A and B : a 와 b사이의 데이를 검색, a는 b보다 작은 값으로 정의
      in(a,b,c...)    : a,b,c..의 값을 가지고 있는 데이터를 검색
      like (%, _와 같이 사용) : 특정 패턴을 가지고 있는 데이터를 검색
            -> '%A' 끝이 A로 끝나는 데이터, 'A%' A로 시작, '%A%' A를 포함
						-> _: 문자열 한개 A_B: A1B, AaB, AXB -O / A11B,A__B-> A11B->O
      is null/ is not null : null값 여부를 가지고 있는 데이터를 검갯
			
			
      
*/
--A. 비교연산자
--1. 급여(sal)가 5000인 사원 조회

select ename,sal from emp;
select ename,sal from emp where sal=5000;

select ename,sal
	from emp
	where sal=1600;
	
--2. 급여가 900보다 큰(작은, 크거나 같은 , 작거나 같은, 아닌) 사원
select ename,sal from EMP WHERE SAL>950;
select ename,sal from EMP WHERE SAL<950;
select ename,sal from EMP WHERE SAL>=950;
select ename,sal from EMP WHERE SAL<=950;
select ename,sal from EMP WHERE SAL<>950;
select ename,sal from EMP WHERE SAL!=950;

--3. 사원 이름이 smith인 사원만 조회
select * from emp where ename='SMITH';

--4. 대소문자변환함수
select ename,lower(ename) from emp where ename='SMITH';
select ename,lower(ename),upper(ename) from emp where ename='SMITH';

select * from emp where lower(ename)='smith';
select * from emp where lower(ename)='SMITH';
select * from emp where upper(lower(ename))='SMITH';

--5. 입사일자(hiredate)
--입사일자가 1980-12-17인 사원을 조회
--hint) date type은 문자열로 비교가능
select ename,hiredate from emp;
select ename,hiredate from emp where hiredate=1980-12-17; --error

select ename,hiredate from emp where hiredate='1980-12-17';
select ename,hiredate from emp where hiredate='19801217'; --DB엔진(오라클) date=문자열(자동형변환)
select ename,hiredate from emp where hiredate='1980.12.17';
select ename,hiredate from emp where hiredate='1980/12/17';

--실습문제 
--1.급여가 1000보다 작은 사원만 출력하기
select ename,sal,hiredate from emp where sal<1000;

--2. 부서 테이블에서 부서번호와 부서명을 별칭으로 한 sql 작성
select * from dept;
select deptno as 부서번호, dname as 부서명 from dept; --as생략가능

--3. 사원 테이블에서 직급만 출력/ 중복되지않게
select *from emp;
select DISTINCT job from emp;

--4. 급여가 800인 사원만 조회
select * from emp where sal=800;

--5. 사원명이 blake인 사원만 출력
select * from emp where lower(ename)='blake';

--6. 사원 이름 james~martin사이의 사원을 사원번호, 사원명, 급여를 출력
select empno,ename,sal from emp where ename between 'JAMES' and 'MARTIN';


---6. between ,in , like
--입사 일자가 1980.12.01~1980.12.31까지의 사원 출력
select ename,hiredate from emp where hiredate >='19801201' and hiredate<='19801231';
select ename,hiredate from emp where hiredate between '19801201' and '19801231';

select * from emp where sal=800;
select * from emp where sal='800'; --sal의 data Type이 number -> 숫자로 자동형 변환이되어 success

--and or 연산자
select ename,hiredate from emp where hiredate >='19801201' or hiredate<='19801231';

--7. in: 컬럼명 in(값1...)
--부서가 10,20인 사원을 출력
select ename,deptno from emp where deptno=10 or deptno=20;
--or대신 in연산자 사용
select ename,deptno from emp where deptno in(10,20);

--8. order by: 정렬
select * from emp t1 where deptno=30;
--ename순서로 정렬(정/역순)
select * from emp t1 where deptno=30 order by ename;

















