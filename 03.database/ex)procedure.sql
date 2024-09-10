
/* 연습문제 */
-- view연습문제를 procedure로 만들어 보세요
-- dbms_output.put_line
-- 프로시저이름 ex_01 ~ ex_06
-- ex01) professor, department을 join 교수번호, 교수이름, 소속학과이름 조회 
select * from professor;
select * from department;

create or replace procedure ex_01 is 
	v_profno  professor.profno%type;
	v_pname		professor.name%type;
	v_deptno  department.deptno%type;
	v_dname 	department.dname%type;

begin
	select prf.profno, prf.name, dep.dname
	  into v_profno, v_pname, v_dname 
		from professor prf , department dep 
	 where prf.deptno=dep.deptno;

	 dbms_output.put_line('번호:' || v_profno ||'이름:' ||  v_pname || '학과:' ||v_dname);
	
end ;

call ex_01();

-- ex02) inline view를 사용, student, department를 사용 학과별로
-- 학생들의 최대키, 최대몸무게, 학과명을 출력
-- ex03) inline view를 사용, 학과명, 학과별최대키, 학과별로 가장 키가 큰 학생들으;
-- 이름과 키를 출력
-- ex04) student에서 학생키가 동일학년의 평균키보다 큰 학생들의 학년과 이름과 키
-- 해당 학년의 평균키를 출력 단, inline view로
-- ex05) professor에서 교수들의 급여순위와 이름, 급여출력 단, 급여순위 1~5위까지
-- ex06) 교수번호정렬후 3건씩해서 급여합계와 급여평균을 출력