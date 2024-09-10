
/* 연습문제 */
select * from emp;
select * from student;
-- 1. emp 테이블을 사용하여 사원 중에서 급여(sal)와 보너스(comm)를 합친 금액이 가장 많은 경우와 
--    가장 적은 경우 , 평균 금액을 구하세요. 단 보너스가 없을 경우는 보너스를 0 으로 계산하고 
--    출력 금액은 모두 소수점 첫째 자리까지만 나오게 하세요
-- MAX, MIN, AVG
select max(sal+nvl(comm,0)),min(sal+nvl(comm,0)),to_char(round(avg(sal+nvl(comm,0)),0),'$999,999')
from emp;

--select round(avg(sal+nvl(comm,0)),1),round(avg(sal),1)+round(avg(nvl(comm,0)),1)
--from emp;

-- 2. student 테이블의 birthday 컬럼을 참조해서 월별로 생일자수를 출력하세요
-- TOTAL, JAN, ...,  5 DEC
--  20EA   3EA ....
select to_char(to_date(birthday),'YYYY.MM.DD')생년월일, substr(birthday,4,2)월,
				case substr(birthday,4,2)
			
from student 
group by birthday;


-- 3. Student 테이블의 tel 컬럼을 참고하여 아래와 같이 지역별 인원수를 출력하세요.
--    단, 02-SEOUL, 031-GYEONGGI, 051-BUSAN, 052-ULSAN, 053-DAEGU, 055-GYEONGNAM
--    으로 출력하세요
select  count(decode(substr(tel, 1, instr(tel, ')', 1) - 1), '02',  '02')) as "02-SEOUL",
				count(decode(substr(tel, 1, instr(tel, ')', 1) - 1), '031',  '031')) as "031-GYEONGGI",
				count(decode(substr(tel, 1, instr(tel, ')', 1) - 1), '051',  '051')) as "051-BUSAN",
				count(decode(substr(tel, 1, instr(tel, ')', 1) - 1), '052',  '052')) as "052-ULSAN",
				count(decode(substr(tel, 1, instr(tel, ')', 1) - 1), '053',  '053')) as "053-DAEGU",
				count(decode(substr(tel, 1, instr(tel, ')', 1) - 1), '055',  '055')) as "055-GYEONGNAM"					
from student;


-- 4. emp 테이블을 사용하여 직원들의 급여와 전체 급여의 누적 급여금액을 출력,
-- 단 급여를 오름차순으로 정렬해서 출력하세요.
-- sum() over()
select sal as 직원급여 ,sum(sal+nvl(comm,0)) as 전체급여, sum(sal+nvl(comm,0)) over(order by sal) as 누적급여금액
from emp
order by sal;


-- 6. student 테이블의 Tel 컬럼을 사용하여 아래와 같이 지역별 인원수와 전체대비 차지하는 비율을 
--    출력하세요.(단, 02-SEOUL, 031-GYEONGGI, 051-BUSAN, 052-ULSAN, 053-DAEGU,055-GYEONGNAM)
       

-- 7. emp 테이블을 사용하여 부서별로 급여 누적 합계가 나오도록 출력하세요. 
-- ( 단 부서번호로 오름차순 출력하세요. )

-- 8. emp 테이블을 사용하여 각 사원의 급여액이 전체 직원 급여총액에서 몇 %의 비율을 
--    차지하는지 출력하세요. 단 급여 비중이 높은 사람이 먼저 출력되도록 하세요
select ename,sum(sal+nvl(comm,0)) as 사원급여액 ,round(ratio_to_report(sum(sal+nvl(comm,0))) over() * 100,2) as 급여총액비율
from emp;



-- 9. emp 테이블을 조회하여 각 직원들의 급여가 해당 부서 합계금액에서 몇 %의 비중을
--     차지하는지를 출력하세요. 단 부서번호를 기준으로 오름차순으로 출력하세요.
