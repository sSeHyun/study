/*
   그룹함수
   
   1. count() : 조회되는 데이터들의 총 건수
   2. sum()   : 조회되는 데이터들을 총 합계
   3. avg()   : 조회되는 데이터들을 평균
   4. max()   : 조회되는 데이터들중 최대값
   5. min()   : 조회되는 데이터들을 최소값
   6. stddev(): 조회되는 데이터들을 표준편차값
   7. variance(): 조회되는 데이터들을 분산값
   8. rollup()
   9. cube()
   10. groupingset()
   11. listagg()
   12. pivot() / unpivot()
   13. lag()
   14. lead()
   15. rank()
   16. dense_rank()
   17. sum() over()
   18. ration_to_report()
   
*/
select * from emp;

--1. count: 조건에 맞는 데이터의 수를 리턴

select count(*) from emp;
select count(ename) from emp;
select count(comm) from emp;
select count(nvl(comm,0)) from emp;

select count(*) from emp where deptno=10;
select count(*),count(ename),count(comm),count(nvl(comm,0)) from emp;

--2. sum() -only 숫자타입

select sum(ename)from emp; --error invalid number
select sum(sal) from emp;
select sum(sal),sum(comm) from emp;
select sum(sal),sum(comm),sum(nvl(comm,0)) from emp;

--3. avg() 
select count(ename) as 총사원수
			,sum(sal) as 총급여
			,round(avg(sal),2) as 평균급여
			,round(sum(sal)/count(ename),2) as 평균급여
from emp;


select count(ename) as 총사원수
			,sum(sal) as 총급여
			,round(avg(sal),2) as 평균급여
			,round(sum(sal)/count(ename),2) as 평균급여
from emp
where deptno=10;

--4. min/max
select min(ename),max(ename) from emp;
select min(sal),max(sal) from emp;
select min(comm),max(comm) from emp;
select min(nvl(comm,0)),max(nvl(comm,0)) from emp;

select min(sal+comm),max(sal+comm) from emp 	--null미처리 결과
union all
select min(sal+nvl(comm,0)),max(sal+nvl(comm,0)) from emp;  --null처리 결과


--3) 날짜
select min(hiredate) 최초입사일자
			,max(hiredate) 최근입사일자
from emp;

--최초입사일의 사원과 최근입사 사원의 이름
select ename, hiredate
from emp
where hiredate=(select min(hiredate) from emp)

union all

select ename ,hiredate 
from emp
where hiredate=(select max(hiredate) from emp)

--최저연봉자, 최고연봉자의 사원 이름
select ename, sal
from emp
where sal=(select min(sal) from emp)

union all

select ename ,sal 
from emp
where sal=(select max(sal) from emp)


--5. stddev()/variance()
select stddev(sal), variance(sal) from emp;


/*
		B. GROUP BY(데이터를 그룹화 하기)
		
		select 그룹화 기준, 그룹함수 from 테이블 group by  그룹기준
		
		-- 주의사항
		-- 1. select절에 사용된 그룹함수 이외의 컬럼이나 표현식은 반드시 group by 절에 정의 되어야 한다.
					select deptno, sum(sal) from emp group by deptno;
		--    group by 절에 사용된 컬럼이라도 select절에 사용되지 않아도 된다.
					select sum(sal) from emp group by deptno;
		-- 2. group by절에는 반드시 컬럼명이 사용되어야 한다. 즉, 컬럼의 alias(별칭)는 사용할 수 없다.
					select deptno as 부서번호, sum(sal) from emp group by 부서번호; --error 
		-- 3. group by절을 사용한 select문에 order by절로 정렬을 하기 위해서는 order by절은 group by절
		--    뒤에 정의해야 한다. order by 절에서는 별칭도 정의가 가능하다.
*/

select deptno, sum(sal) from emp; --error  not a single-group group function
select deptno, sum(sal) from emp group by deptno;
select sum(sal) from emp group by deptno;

--group by절에는 반드시 컬럼명 사용(별칭사용불가)
select deptno as 부서번호, sum(sal) from emp group by 부서번호; --error
select deptno as 부서번호, sum(sal) from emp group by deptno;

--order by는 group by를 사용할 경우에는 반드시 group by절 뒤에 위치해야한다.
select deptno, sum(sal) from emp order by deptno group by deptno; --error command not properly ended
select deptno as 부서번호, sum(sal) from emp  group by deptno order by deptno;
--order by는 컬럼순서 or 별칭도 가능하다.
select deptno as 부서번호, sum(sal) from emp  group by deptno order by 1;
select deptno as 부서번호, sum(sal) from emp  group by deptno order by 부서번호; --order by는 별칭 사용가능


--부서별로 총급여를 출력
select 10 부서번호,sum(sal) from emp where deptno=10
union all 
select 20,sum(sal) from emp where deptno=20
union all 
select 30,sum(sal) from emp where deptno=30;


select deptno,sum(sal) from emp group by deptno order by deptno;


--실습
select * from emp;
-- ex01) 부서별로 사원수와 급여평균, 급여합계를 구하기, 정렬은 부서(deptno)

select deptno as 부서번호,count(ename) as 부서별사원수,to_char(trunc(avg(sal)),'$999,999') as 급여평균,to_char(sum(sal),'$999,999') as 급여합계 
	from emp group by deptno order by 1;


-- ex02) 직급별로 인원수, 평균급여, 최고급여, 최소급여, 급여합계, 정렬은 직급(job) 

select job,count(ename),to_char(trunc(avg(sal)),'$999,999') as 평균급여 ,to_char(min(sal),'$999,999') as 최소급여,to_char(max(sal),'$999,999')as 최고급여,to_char(sum(sal),'$999,999') as 급여합계
from emp group by job order by 1;


select job, 
			count(*),
			sum(sal),
			round(avg(nvl(comm,0)),2),
			min(sal),
			max(sal) 
from emp where job='ANALYST' group by job;


select *
from (select job, 
						count(*),
						sum(sal),
						round(avg(nvl(comm,0)),2),
						min(sal),max(sal)	
						from emp group by job order by 1)
where job='ANALYST';



/* C. 그룹결과를 조건별 결과 구하기(having) */
-- 단일행 함수에서 사용했던 where조건문과 동일하다.
-- 즉, 그룹화에서 조건을 주기 위해서는 having절을 사용하고 where절에는 집계함수를
-- 사용할 수 없다. 
-- having절은 집계함수를 가지고 조건을 비교할때 사용되며 having절을 group by절과
-- 함께 사용한다. 즉, having절을 group by절 없이 사용할 수 없다.


select job, 
			count(*),
			sum(sal),
			round(avg(nvl(comm,0)),2),
			min(sal),
			max(sal) 
from emp group by job  having job='ANALYST' order by 1;


--평균급여 >= 3000
select job, 
			count(*),
			sum(sal),
			round(avg(nvl(comm,0)),2),
			min(sal),
			max(sal) 
from emp group by job having round(avg(nvl(comm,0)),2)>=550;



--실습. 부서별 / 직급별 / 부서별 소계 / 총계 
--1. 부서별, 직급별, 사원수, 평균급여
--2. 부서별 사원수/평균급여
--3. 총계  사원수, 평균급여
--를 하나의 결과로 출력하기


select * from emp;

select * 
from(
			select deptno,job,count(*),sum(sal) from emp group by deptno, job
			union all 
			select deptno,null,count(*),sum(sal) from emp group by deptno
			union all 
			select null,null,count(*),sum(sal) from emp )
order by deptno;


/* D. 소계 및 총계구하기 */
-- 1. rollup()
--    rollup절은 group by절과 같이 사용되며 group by절에 의해서 그룹지어진 집합결과
--    에 대새허 좀 더 상세한 정보를 반환한다. 즉, 소계, 총계를 그룹별로 구할 수 있다.
--    select절에 rollup을 사용함으로 보통의 select된 데이터와 그 데이터의 소계, 총계를
--    구할 수 있다.


-- 직급별 급여합계, 총계 구하기
select * from(
							select job,sum(sal) from emp group by job
							union all 
							select null, sum(sal) from emp)
	order by deptno,job;						
							
select job,sum(sal) from emp group by rollup(job);
select *
from (select deptno,job,count(*),sum(sal) from g

select * from professor;



-- 실습. 부서별/직급별, 부서별소계, 총계
-- 1. 부서별, 직급별, 사원수, 평균급여
-- 2. 부서별          사원수, 평균급여
-- 3. 총계            사원수, 평균급여
-- 하나의 결과로 출력하기
select * 
from (select deptno, job, count(*), sum(sal) from emp group by deptno, job
			 union all 
			 select deptno, null, count(*), sum(sal) from emp group by deptno
			 union all 
			 select null , null, count(*), sum(sal) from emp)
order by deptno, job; 

select deptno, job, count(*), sum(sal) 
  from emp 
 group by rollup(deptno, job);
 
-- rollup은 자동으로 소계와 합계를 구해주는 함수
-- group by rollup(deptno, job) -> 그룹 3개(M+1)의 그룹이 생성
select deptno, job, count(*), sum(sal) 
  from emp 
 group by deptno, rollup(job); -- 그룹 M+1 -> 2개, 즉 결과는 총계없음


--실습
--professor 테이블에서 deptno, position별로 교수인원수, 급여합계(rollup함수 이용)
select deptno,position,count(*), sum(pay)
from professor
group by rollup(deptno,position);

--실습. 총계, 부서소계, 부서, 직급

select null,null, sum(sal) from emp
union all 
select null,job,sum(sal) from emp group by job
union all 
select deptno,job,sum(sal) from emp group by deptno,job;


select deptno, job, count(*), sum(sal) 
  from emp 
 group by rollup(deptno,job);


select deptno, job, count(*), sum(sal) 
  from emp 
 group by cube(deptno,job);


--3. grouping sets()함수
--그룹핑 조건이 여러개일 경우 한번에 sql실행하기
--실습. student에서 학년별 인원수와 전공별 인원수 구하기
select * from student;

select grade,count(*) from student group by grade
union all 
select deptno1, count(*) from student group by deptno1;


select grade,deptno1,count(*)
from student
group by grade,deptno1;


select grade,deptno1,count(*)
from student
group by grouping sets(grade,deptno1);



/* E. 순위함수 

    1. rank()함수는 순위를 부여하는 함수로서 동일순위처리가 가능(중복순위 1,2,2,4)
    2. dense_rank()함수는 동일순서의 처리에 영향이 없다.(중복순위, 1,2,2,3)
    3. row_numer()함수는 특정순위의 일련번호를 제공하는 함수 동일순위처리 불가(1,2,3,4,)
    
    주의사항
    순위함수 사용시에는 order by절은 필수로 정의해야 한다.
*/

--1. rank()
--1) 특정자료의 순위: rank(조건식) within group(order by 조건식 컬럼명 [asc|desc])
--2) 전체순위 : rank( ) over(order by 조건식 컬럼명 [asc|desc])
--3) 그룹별 순위 : rank() over(partition by 컬럼...order by 컬럼)

-- 특정조건에서의 순위

--SMITH가 몇번째에 위치하는지(이름(알파벳)순에서)
select rownum,ename from (select ename from emp order by ename);
select rank('SMITH') within group(order by ename) from emp;
select rank('SMITH') within group(order by ename asc) from emp;
select rank('SMITH') within group(order by ename desc) from emp;


--2) 전체순쉬
--emp에서 사원들의 급여순서
select empno,ename,sal
			,rank() over(order by sal) 급여내림차순
			,rank() over(order by sal desc) 급여오름차순
from emp;


--3) 전체에서 그룹별 순위
--그룹별 순위를 구할때 partition by를 사용한다
--부서별 내 급여의 순위?

select deptno,ename,sal,rank() over(partition by deptno order by sal) from emp;


--부서별 직급별 급여순위

select deptno, job,sal, rank() over(partition by deptno, job order by sal) from emp;

--2. dense_rank()
select ename,sal,
			rank() over(order by sal) rank, 
			dense_rank() over(order by sal) dense_rank 
			from emp;


--3. row_number()
select ename,sal,
			rank() over(order by sal) rank, 
			dense_rank() over(order by sal) dense_rank,
			row_number() over(order by sal) row_number 
from emp



/* F. 합계함수
       1. sum() over        : 누계를 구하는 함수
            ... sum(컬럼) over (order by 컬럼(기준열))
       2. ratio_to_report() : 비율을 구하는 함수
*/


/*
		누적 합계 구할 때 sum() over 사용
		ex) 1일 1000    sum over() 1000
				2일 500     sum over() 1500
				3일 300     sum over() 1800
				
		총판매액 비율에서 1일 판매액의 비율
		100%   1000
		100     10%
*/

--1.panmae테이블에서 1000번 대리점의 판매누계구하기
--(판매일자, 제품코드, 수량, 판매량,누계)

select * from panmae;
select to_char(to_date(p_date),'YYYY.MM.DD')판매일,p_code,p_qty,p_total from panmae where p_store=1000;


select to_char(to_date(p_date),'YYYY.MM.DD')판매일,
			p_code,p_qty,p_total,sum(p_total)판매누계 from panmae where p_store=1000 group by p_date,p_code,p_qty,p_total;

select to_char(to_date(p_date),'YYYY.MM.DD')판매일,
			p_total,
			sum(p_total) over(order by p_date)판매누계 
			from panmae where p_store=1000;

--실습. 
--1.상기예제를 제품코드별로 누계 구하기 
--sum() over(partition by order by )
select to_char(to_date(p_date,'YYYY-MM-DD')),p_code,
				sum(p_total) over(partition by p_code order by p_date)
				from panmae;



--2. 전체대리점에서 제품 코드/ 대리점별 누계 구하기
select to_char(to_date(p_date,'YYYY-MM-DD'))판매일, p_code, p_store,p_total,
			sum(p_total) over(partition by p_code,p_store order by p_date)
			from panmae; 



select p_code
				,sum(p_qty) over() tot_qty
				,sum(p_total) over() tot_amt
				,p_store
				,p_total
				,round(ratio_to_report(sum(p_qty)) over() *100 ,2) "수량(%)" 
				from panmae where p_store=1000 group by p_code,p_store,p_qty,p_total;

