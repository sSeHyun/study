-- dual 테이블 : 이 테이블은 dummy라난 단 하나의 컬러에 한개의 row만을 저장하고 
-- 있기 때문에 이 값은 아무런 의미가 없다. 쿼리의 수행결과가 하나의 값으로 임시로
-- 실행하고자 할 때 임시테이블로서의 역할을 제공한다.

select * from dual;
select sysdate from dual;
select 2*222 from dual;

/*
	단일행 함수(single_function)
*/
	--    1) upper   : 소문자를 대문자로 변환 : upper('aBcdE') -> ABCDE
	--    2) lower   : 대문자를 소문자로 변환 : lower('aBcdE') -> abcde
	--    3) initcap : 첫글자를 대문자, 나머지는 소문자로 변환 : initcap('aBcdE') -> Abcde
		select initcap('hello world')from dual;
		select ename,initcap(ename) from emp;
		select name,initcap(name) from professor;

	--    4) length  : 문자길이를 리턴(한글인 경우 1byte) : length('한글') -> 2 
	--    5) lengthb : 문자길이를 리턴(한글인 경우 2byte) : lengthb('한글') -> 4 
		select ename,length(ename),lengthb(ename) from emp where deptno=10;
		select length('소향'), lengthb('소향') from dual;
		
	--    6) concat  : 문자의 값을 연결 (||와 동일) : concat('A', 'B') -> AB
	select ename||job, concat(ename,job)m, concat('소향의 직업은','가수입니다!') from emp;
	select 'A'||'B'||'C' from dual;
	select concat(concat('A','B'),'C') from dual;
	--    7) substr  : 주어진 문자에서 특정 문자만 추출 : substr('ABC',1,2) -> AB
					--substr(값,from, 갯수)
	select 'abcde', substr('abcde',3,2), 
									substr('abcde',-2,2), 
									substr('abcde',-3,3),
									substr('abcde',3,3), 
								  substr('abcde',3,3000000),
									substr('abcde',3,-1)  --null값
									from dual;
	--    8) substrb : 주어진 문자에서 특정 위치의 바이트만 추출 : substrb('한글',1,2) -> 한
	select '홍길동' name, substr('홍길동',1,2), substrb('홍길동',1,2) , substrb('홍길동',1,3)from dual; --substrb('홍길동',1,2) 는 Rowla 홍(3바이트)에서 2바이트만 가져옴
	--    9) instr   : 주어진 문자에서 특정문자의 위치를 리턴 : instr("A*B#C#D", '#') -> 4
					--instr(문자열, 찾는글자, 시작위치, 몇번째(기본값 1)): 찾는 문자의 위치를 리턴 //음수값은 뒤에서 부터 검색
	select 'A*B*C*D',instr('A*B*C*D','*') ,instr('A*B*C*D','*',1,3),instr('A*B*C*D','*',3,1),instr('A*B*C*D','*',3,2)from dual;
	select instr('HELLO World','O'),instr('HELLO World','o') from dual;
	--   10) instrb  : 주어진 문자에서 특정문자의 위치 바이트를 리턴 : instr("한글로", "로") -> 5
	select instrb('한글로','한'),instrb('한글로','글'),instrb('한글로','로') from dual;
	--   11) lpad    : 주어진 문자열에서 왼쪽으로 특정 문자를 채움 : lpad('love', 6, '*') -> **love 
			--lpad(문자열,자리수,채울문자)
	--   12) rpad    : 주어진 문자열에서 왼쪽으로 특정 문자를 채움 : rpad('love', 6, '*') -> love**
			--rpad(문자열,자리수,채울문자)
			select '991234-2' ||'******' from dual;
			select name,jumin,substr(jumin,1,6)||'-'||substr(jumin,7,1)||'******' from student;
			
			select name,id,length(id),lpad(id,10,'*'),rpad(id,10,'*') from student where deptno1=101;
			select '***hong###' ,lpad('***hong###',10,'*'),rpad('***hong###',10,'#') from dual;
	--ex01) lpad() emp.ename: 1234CLARK ,12345KING, 123MILLER -->길이가 9인것을 전제
	--ex02) rpad() emp.ename: CLARK1234 ,KING12345, MILLER123 -->길이가 9인것을 전제
			select * from emp;
			select ename,lpad(ename,9,'123456789') as lpad ,rpad(ename,9,'123456789') as rpad from emp;
	--ex03) lpad() emp.ename: 1234CLARK ,12345KING, 123MILLER -->길이가 9인것을 전제
	--ex04) rpad() emp.ename: CLARK6789 ,KING56789, MILLER789 -->길이가 9인것을 전제	
			select ename, rpad(ename,9,substr('123456789',length(ename),9)) as rpad from emp;
				
	--   13) ltrim   : 주어진 문자열에서 왼쪽의 특정 문자를 삭제 : ltrim('*love', '*') -> love
	--   15) rtrim   : 주어진 문자열에서 오른쪽의 특정 문자를 삭제 : ltrim('love*', '*') -> love
		--ltrim(문자열, 제거할 문자),rtrim(문자열,제거할 문자)
		select ename,ltrim(ename,'C'),rtrim(ename,'R'),ltrim('CLAR'),rtrim(ename,'LLER'), , ltrim('*love', '*')	, rtrim('love*', '*')
		 , ltrim('*!@#love', '*')	
		 , rtrim('love*!@#', '*')		 
		 , ltrim('*!@#love', '*!@#')	
		 , rtrim('love*!@#', '*!@#') from emp where deptno=10;
	--   16) replace : 주어진 문자열에서 A를 B로 치환 : replace("AB", "A", "E") -> EB 
	--replace(문자열, 변경할 문자, 대체할 문자)
	select ename,'KING -> **NG',replace(ename,'KI','**') from emp where deptno=10;
			--실습 **NG, **ARK, **LLER
	select ename,'KING -> **NG',replace(ename,'KI','**'),replace(ename,'CL','**'),replace(ename,'MI','**') from emp where deptno=10;
	select ename,replace(ename,substr(ename,1,2),'**') from emp where deptno=10;
	-- 실습.
	select * from student;
-- ex01) student 테이블의 주민등록번호 에서 성별만 추출
select  jumin,substr(jumin,7,1) as 성별 from student; 
-- ex02) student 테이블의 주민등록번호 에서 월일만 추출
select  jumin,substr(jumin,3,4) as 월일 from student; 
--8월에 태어난 학생에서 선물
select name, jumin,substr(jumin,3,2) as 월 from student where substr(jumin,3,2)='08';
-- ex03) student 테이블에서 jumin컬럼을 사용, 1전공이 101번인 학생들의
--       이름과 태어난월일, 생일 하루 전 날짜를 출력
select name, substr(jumin,3,4) as 월일 ,substr(jumin,3,4)-1 as 생일하루전 from student where deptno1='101';

select name, substr(jumin,3,4) as 월일 ,substr(jumin,3,4)-1 as 생일하루전 from student where substr(jumin,3,2)='08' and deptno1='101';
	

-- 실습. replace, substr, instr
select * from student where DEPTNO1=102;
	--    9) instr   : 주어진 문자에서 특정문자의 위치를 리턴 : instr("A*B#C#D", '#') -> 4
-- ex01) emp에서 20부서에 사원들의 이름과 3~4번째글자를 '-' 변경 SMITH --> SM--H
select ename ,replace(ename,substr(ename,3,2),'--') from emp where deptno=20;
-- ex02) student에서 deptno1=101 학생들의 이름과, 주민번호를 출력하는데
--       주민번호 7자리는 '-'와 '/'로 표시되게 123456-/-/-/- 
select name,replace(jumin,substr(jumin,7,7),'-/-/-/-')from student where deptno1=101;
-- ex03) student에서 deptno1=102 학생들의 이름과 전화번호에서 
--       국번만 '*'처리 (조건 모든 국번은 3자리) 051)999-9999 --> 051)***-9999 
select name,replace(tel,substr(tel,5,3),'***')from student where deptno1=102;
select name,
			tel,
			instr(tel,')',1)+1
			,replace(tel,substr(tel,instr(tel,'-',1)+1,4)'****')
			from student 
			where deptno1=102;





/*
   B. 숫자함수
   
   1. round : 주어진 실수를 반올림
   2. trunc : 주어진 실수를 버림
   3. mod   : 나누기연산후 나머지값을 리턴
   4. ceil  : 주어진 실수값에서 가장 큰 정수값을 리턴
   5. floor : 주어진 실수값에서 가장 작은 정수값을 리턴
   6. power : 주어진 값을 주어진 승수를 리턴 power(3,3) -> 3 x 3 x 3 = 27
   7. rownum : 오라클에서만 사용되는 속서으로 모든 객체에 제공된다.
      ... rownum은 전체열 즉, *와 같이 사용할 수 없다.
       ... rownum은 행번호를 의미
*/


--  1. round : 주어진 실수를 반올림

select 987.654
			,round(987.654)	--0
			,round(987.654,1)		--1
			,round(987.654,2)		--2
			,round(987.654,-1)	-- -1
			,round(987.654,-1)-- -2
from dual;

--  2. trunc : 주어진 실수를 버림
select 987.654
,trunc(987.654,0)
,trunc(987.654,1) 
,trunc(987.654,2)	
,trunc(987.654,-1)
,trunc(987.654,-2)
from dual;



select 'round=',987.654
			,round(987.654)	--0
			,round(987.654,1)		--1
			,round(987.654,2)		--2
			,round(987.654,-1)	-- -1
			,round(987.654,-1)-- -2
from dual

union all

select 'trunc=',987.654
			,round(987.654)	--0
			,round(987.654,1)		--1
			,round(987.654,2)		--2
			,round(987.654,-1)	-- -1
			,round(987.654,-1)-- -2
from dual;



--3. mod   : 나누기연산후 나머지값을 리턴.
select 121
,mod(121,10)  --120/10의 나머지값
,ceil(123.45) --값에서 가장 큰 정수
,floor(123.45) --값에서 가장 작은 정수
from dual;


--6. power : 주어진 값을 주어진 승수를 리턴 power(3,3) -> 3 x 3 x 3 = 27
select power(2,3) from dual;
select power(3,3) from dual;

-- 7. rownum : 오라클에서만 사용되는 속서으로 모든 객체에 제공된다.
--      ... rownum은 전체열 즉, *와 같이 사용할 수 없다.
--       ... rownum은 행번호를 의미


select * from student;
select rownum, * from student; --error
select rownum, name,jumin from student;

select rownum, name,jumin from student where deptno1=101;

select rownum, name,jumin 
	from student 
	where deptno1=101 order by name;

select rownum,name 
from
	(select rownum,name,jumin 
		from student 
		where deptno1 =101 order by name);
		
	
/*
   C. 날짜함수
*/   
--1. sysdate : 시스템의 현재일자 : 날짜형으로 리턴
select sysdate from dual;
--2. months_between : 두 날짜 사이의 개월수를 리턴 : 숫자형으로 리턴
select Months_between(sysdate,'20210516')from dual;
--emp에서 각 사원의 근속월수는
select ename,hiredate, 
					round(months_between(sysdate,hiredate),2) ,
				round(round(months_between(sysdate,hiredate),2)/12)  from emp;
--3. add_months : 주어진 일자에 개월수를 더한 결과를 리턴 : 날짜형
select sysdate
	,ADD_MONTHS(SYSDATE,5)
	,ADD_MONTHS(SYSDATE,-5)
	from dual;
--4. next_day : 주어진 일자를 기준으로 다음 날짜를 리턴 : 날짜형
select sysdate
		,NEXT_DAY(sysdate, 1) --현재일의 다음번의 일요일
		,NEXT_DAY(sysdate, 2) --현재일의 다음번의 월요일
		,NEXT_DAY(sysdate, 3) --현재일의 다음번의 화요일
		,NEXT_DAY(sysdate, 4) --현재일의 다음번의 수요일
		,NEXT_DAY(sysdate, 5) --현재일의 다음번의 목요일
		,NEXT_DAY(sysdate, 6) --현재일의 다음번의 금요일
		,NEXT_DAY(sysdate, 7) --현재일의 다음번의 토요일
		from dual;
--5. last_day : 주어진 일자에 해당하는 월의 마지막일자를 리턴
select sysdate
		,last_day(sysdate)
		,last_day('20240910')
		,last_day('2024.09.10')
		,last_day('2024-09-10')
		,last_day('2024/09/10')
from dual;

--6. round : 주어진 날짜를 반올림
--7. trunc : 주어진 날짜를 버림
select sysdate
		,round(sysdate)
		,round('20240910')
		,trunc(sysdate)
		,trunc('20240910')
from dual;

select sysdate
		,round(sysdate)
		,round(to_date('20240830'))
		,trunc(sysdate)
		,trunc(to_date('20240830'))
from dual;


/* D. 형변환함수
--자동형변환(암묵적/묵시적형변환)
--강제형변환(명시적)


--1. to_char()  : 날짜 or 숫자를 문자로 변환함수
--2. to_number(): 문자형숫자를 숫자로 변환(단, 숫자형식에 맞아야 함)
--3. to_date()  : 문자형을 날짜로 변환(단, 날짜형식에 맞아야 함)
*/

--1. 자동(묵시적,암묵적)형변환
select '2'+2 from dual;
select 2+'2' from dual;

--2. 수동(명시적)형변환
select to_number('2') + 2 from dual;

--형변환에러
select '2a'+ 2 from dual;
select 'A'+2 from dual;

--2. to_char()
--1)날짜를 문자로 변환
select sysdate
		,to_char(sysdate)
		,to_char(sysdate,'YYYY') --년
		,to_char(sysdate,'RRRR')
		,to_char(sysdate,'YY')
		,to_char(sysdate,'RR')
		,to_char(sysdate,'YEAR')
		,to_char(sysdate,'year')
		from dual;


select sysdate
	,to_char(sysdate,'MM')  --월
	,to_char(sysdate,'MON')
	,to_char(sysdate,'MONTH')
	,to_char(sysdate,'mm')
	,to_char(sysdate,'mon')
	,to_char(sysdate,'month')
from dual;

select sysdate
	,to_char(sysdate,'DD') --일
	,to_char(sysdate,'DAY')
	,to_char(sysdate,'DDTH')
	,to_char(sysdate,'dd')
	,to_char(sysdate,'day')
	,to_char(sysdate,'ddth')
from dual;


--날짜형식
select sysdate
		,to_char(sysdate,'YYYY.MM.DD')
		,to_char(sysdate,'yyyy.mm.dd')
	  ,to_char(sysdate,'yyyy.mm.dd hh:mi:ss')
		,to_char(sysdate,'yyyy.mm.dd hh24:mi:ss')
		,to_char(sysdate,'MON.DD.YY hh:mi:ss')
from dual;


--2) 숫자를 문자로 변환
--12345 ->천단위(12,345), 소수점(12345.00) 형태로 변환
select 1234
		,to_char(1234,'9999')
		,to_char(1234,'9999999999')
		,to_char(1234,'0999999999')
		,to_char(1234,'$99999999')
		,to_char(1234,'$9,999,99')
		,to_char(12345,'$9,999.99') --자리수가 맞지 않는 경우 error
from dual;




/*
   E. 기타함수
   
   1. nvl()    : null값을 다른 값으로 치환하는 함수 nvl(comm, 0)
   2. nvl2()   : null값을 다른 값으로 치환하는 함수 nvl2(comm, true, false)
   3. decode() : 오라클에서만 사용하는 함수 if~else
   4. case     : decode대신에 일반적으로 사용되는 문장
            
            case 조건 when 결과1 then 출력1,
                     [when 결과n then 출력n]
             end as 별칭
*/   



--1.nvl()
select ename, sal comm,sal +comm from emp where ename='SMITH'
union all
select ename,sal,nvl(comm,0),sal+nvl(comm,0) from emp where ename='SMITH';

select name,pay,bonus,nvl(bonus,0)
,pay+nvl(bonus,0) 총급여, to_char(pay+nvl(bonus,0),'$9,999.99')
from professor;

--2. nvl2(값,true(not null),false(null))

select ename,sal,comm,nvl2(comm,ename||'의 커미션은 '||comm||'원입니다!',ename||'의 커미션은 없습니다.')
from emp;



/*
   DECODE 함수
   1) 통상적으로 if~else문을 decode로 표현한 함수로 오라클에서만 사용되는 함수
   2) 오라클에서 자주 사용하는 중요한 함수이다
   3) decode(col, true, false) 즉, col결과(값)가 true일경우 true실행문을 실행, 아니면 fasle실행문을 실행
   4) decode(deptno, 101, true,
                              102, true,
                              103, true, false) -> if~else if~else
   5) decode(deptno, 101, decode()....) 중첩if문   
*/ 













