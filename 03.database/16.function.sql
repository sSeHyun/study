/* Function

    1. Function?
    
       보통의 경우 값을 계산하고 그 결과값을 반환하기 위해서 function을 사용한다.
         대부분 프로시저와 유사하지만 
         1) "in 파리미터"만 사용할 수 있다.
         2) 반드시 반환될 값의 데이타입을 return문에 선언해야 한다.
         
    2. 문법
    
       1) pl/sql block에는 적어도 한개의 return문이 있어야 한다.
         2) pl/sql block은 함수가 수행할 내용을 정의한 본문(body)부분이다.
         3) 선언방법
         
            create or replace function 펑션이름
                (매개변수 in 데이터타입) 
                  return 데이터타입 -> return될 값의 데이터타입을 선언 
            is[as]
                  변수선언
             begin
                  return 변수명 --> 리턴문이 반드시 존재해야 한다.
             end;
*/
-- 오라클 함수(function)는 기본적으로 update/insert/delete를 수행할 수 없다.
	-- 따라서 수행하기 위해 begin문 위에 'pragma autonomous_transaction' 을 선언


--실습1) 사원번호를 입력받아서 사원급여를 10% 인상하는 함수

create or replace function fn_01(p_empno in number) return number
is 
	v_sal 	number;
	pragma autonomous_transaction;
begin 
	select sal
	into v_sal
	from emp
	where empno=p_empno;
	
	dbms_output.put_line( ' 인상 전 급여는' ||v_sal);
	
	
		
	update emp
		 set sal=sal*1.1
	 where empno=p_empno;
	
	commit;
	
	select sal
	into v_sal
	from emp
	where empno=p_empno;
		
	dbms_output.put_line( ' 인상 후 급여는' ||v_sal);
	
	return v_sal;

end fn_01; 


select fn_01(7369) from dual;

select empno,ename,sal, fn_01(empno)
	from emp
 where empno=7369; 

--실습 2) 부피를 계산하는 함수(fn_02)
--매개변수: length ,width,height
--return 부피 (result=length *width *height)

create or replace function fn_02(p_length in number,p_width in number,p_height in number) return number
is
	v_result number;
	
begin
	v_result:=p_length*p_width*p_height;
	return v_result;
	
end fn_02;

select fn_02(10,20,20) from dual;

--실습 3) 현재일을 입력받아서 해당월의 마지막 일자를 구하기
create or replace function fn_03(today in date) return date
is 
	v_lastday date;
begin
	v_lastday:=last_day(today);
	return v_lastday;
end fn_03;
	
select fn_03(sysdate) from dual;



--실습 4) '홍길동' 문자를 받아서 '길동'값을 리턴하는 함수
create or replace function fn_04(name in varchar2)return varchar2
is 
	--v_rename varchar2(10);
begin 
	--v_rename:=substr(name,2,2);
	--return v_rename;
	return substr(name,2,2);
end fn_04;

select fn_04('홍길동') from dual;

--실습 5) 현재일을 입력받아서'2024년09월06일'형태로 리턴하는 함수
create or replace function fn_05(day in date)return varchar2
is 
	v_return_day varchar2(20);
begin
	v_return_day := to_char(day ,'""YYYY"년 "MM"월 "DD"일"');
	return v_return_day;
end fn_05;

select fn_05('20240906') from dual;

--실습 6) 주민번호를 전달받아서 남자 or 여자를 리턴하는 함수

create or replace function fn_06(jumin in varchar2)return varchar2
is 
	v_gender varchar2(10);
begin
	v_gender:= substr(jumin,instr(jumin,'-',1)-1,1);
	if(v_gender = 1 or v_gender = 3) then 
		v_gender := '남자';
	else 
		v_gender := '여자';
	end if;
	return v_gender;
end fn_06;

select name,tel,fn_06(jumin) from student;


select substr('9001234-1111111',instr('9001234-1111111','-',1)+1,1) from dual;


--실습7) emp에서 전사원의 hiredate를 현재일 기준으로 근속년월을 계산하는 함수를 작성한 후에 전사원의 근속년월을 출력

create or replace function fn_07(p_hiredate in date)return varchar2
is
	v_workdays varchar2(30);
begin
    v_workdays := trunc(months_between(sysdate, p_hiredate)/12, 0) || '년'
               || trunc(mod(months_between(sysdate, p_hiredate), 12)) || '개월';
		
    return v_workdays;
end fn_07;


select first_name||'-'||last_name as name,fn_07(hire_date) 
from hr.employees;

select ename,fn_07(hiredate) 
from emp;


















