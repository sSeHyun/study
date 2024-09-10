/* 실습문제 */
-- ex01) 부서의 총 급여를 반환하는 함수
-- get_dept_total_salary
select * from emp;

create or replace function get_dept_total_salary(deptnum in number)return number
is 
	v_total_sal number;
begin 
	select sum(sal)
	into v_total_sal
	from emp
	where deptnum=deptno;
	
	return v_total_sal;

end get_dept_total_salary;




select deptno,get_dept_total_salary(deptno) 
from emp 
group by deptno;


-- ex02) 직원 번호가 주어졌을 때 직원의 관리자 이름을 반환하는 함수
-- get_manager_name
select * from emp;

create or replace function get_manager_name(empnum in number)return varchar2
is 

	v_mgrname varchar2(20);
begin 
	select ename
	into v_mgrname 
	from emp
	where empno=(select mgr
								from emp
								where empno=empnum);
	
	return v_mgrname;

end get_manager_name;

select get_manager_name(7369) as 관리자이름 from dual;



select ename 
from emp
where empno=(select mgr
							from emp
							where empno=7369);


-- ex03) 급여와 커미션을 기준으로 직원의 커미션 비율을 계산하는 함수
-- get_commission_pct
select * from emp;

create or replace function get_commission_pct(p_name in VARCHAR)return number
is 
	result_comm number;
begin
	select
		trunc(nvl(comm,0)/(sal+nvl(comm,0)),3) 
	into result_comm
	from emp
	where p_name=ename;

return result_comm;

end get_commission_pct;



select ename,get_commission_pct('ALLEN') as fn_ratio 
from emp 
where ename='ALLEN';

-- ex04) 부서의 직원 수를 반환하는 함수
-- count_employees_in_dept

create or replace function count_employees_in_dept(deptnum in number)return number
is 
 v_empcnt number;
begin
	select count(*)
	into v_empcnt
	from emp
	where deptno=deptnum;
	
return v_empcnt;

end count_employees_in_dept;

select deptno,count_employees_in_dept(deptno) 
from emp 
group by deptno;

-- ex05) 부서에서 가장 높은 급여를 받는 직원의 이름을 반환하는 함수
-- get_highest_paid_emp
select * from emp;

create or replace function get_highest_paid_emp(deptnum in number)return VARCHAR2
is 
	max_name VARCHAR2(10);
begin
	select ename
	into max_name
	from emp 
	where deptno=deptnum and sal=(select max(sal) 
																from emp  
																where deptno=deptnum)
	and rownum=1;
	return max_name;
end get_highest_paid_emp;


select get_highest_paid_emp(deptno)
from emp
group by deptno;

						
select ename,deptno,sal
from emp
where sal=(select max(sal) 
						from emp e 
						where e.deptno=emp.deptno);




-- ex06) 직원이 관리자인지 확인하는 함수
-- is_manager'
select * from emp;

create or replace function is_manager(empnum in number)return VARCHAR2
is 
	emp_job varchar2(20);
begin
	select job
	into emp_job
	from emp
	where empno=empnum
	and rownum=1;
		
	if emp_job='MANAGER'
	then emp_job := 'MANAGER';
	else emp_job := 'NOT_MANAGER';
	end if;

 
	return emp_job;

end is_manager;

select is_manager(7369)
from dual;


-- ex07) 특정 관리자에게 보고하는 직원의 평균 급여를 구하는 함수
-- get_avg_salary_by_mgr
select * from emp;
create or replace function get_avg_salary_by_mgr(mgrnum in number)return number
is 
	emp_avg number;
begin
	select avg(sal)
	into emp_avg
	from emp
	where mgrnum=mgr;
	
	return emp_avg;
end get_avg_salary_by_mgr;

select get_avg_salary_by_mgr(7698) from dual;

-- ex08) 직원의 근속 기간을 계산하는 함수
-- get_years_of_service
select * from emp;

create or replace function get_years_of_service(emp_hired in date)return varchar2
is 
	emp_date varchar2(50);
begin
	emp_date:=to_char(sysdate-emp_hired);
	return emp_date;
	
end get_years_of_service;

select trunc(get_years_of_service('19801217'),0) from dual;


-- ex09) 직원이 속한 부서의 이름을 반환하는 함수
-- get_dept_name_by_emp
select * from dept;
select * from emp;

create or replace function get_dept_name_by_emp(empnum in number)return varchar2
is 
 dept_name varchar2(30);
begin
 select dname
 into dept_name
 from dept 
 where deptno=(select deptno
								from emp  
								where empno=empnum);
								
			return dept_name;
end get_dept_name_by_emp;

select get_dept_name_by_emp(7521) as 부서이름 from dual;

-- ex10) 직원과 관리자 간의 급여 차이를 계산하는 함수
-- get_salary_difference_with_mgr
select * from emp;

create or replace function get_salary_difference_with_mgr(empnum in number)return number
is 
 mgr_sal number;
 emp_sal number;
 sal_diff number;
 
begin
	select sal
	into emp_sal
	from emp
	where empno=empnum;
	
	select sal
	into mgr_sal 
	from emp
	where empno=(select mgr
								from emp
								where empno=empnum);
			
	sal_diff:= mgr_sal-emp_sal;			
			
	return sal_diff;

end get_salary_difference_with_mgr;

select get_salary_difference_with_mgr(7369) from dual;












