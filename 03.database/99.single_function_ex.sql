-- 실습문제(제출)
select * from emp;
select * from student;
select * from professor;
-- ex01) emp테이블에서 ename, hiredate, 근속년, 근속월, 근속일수 출력, deptno = 10;
-- months_between, round, turnc, 개월수계산(/12), 일수계산(/365, /12)
select ename,hiredate,
			trunc(months_between(sysdate,hiredate)/12*365) as 근속일수,
			round(months_between(sysdate,hiredate),2) as 근속월 ,
			round(months_between(sysdate,hiredate)/12) as 근속년
			from emp where deptno=10;

-- ex02) student에서 birthday중 생일 1월의 학생의 이름과 생일을 출력(YYYY-MM-DD)
select name,to_char(birthday,'YYYY-MM-DD') from student where substr(jumin,3,2)='01';

--ex02_solution)
select name,to_char(birthday,'YYYY-MM-DD') from student where to_char(birthday,'MM')='01';
-- ex03) emp에서 hiredate가 1,2,3월인 사람들의 사번, 이름, 입사일을 출력 
--select empno,ename,substr(hiredate,4,2) from emp;
select empno,ename,hiredate 
	from emp 
	where substr(hiredate,4,2)='01' or substr(hiredate,4,2)='02' or substr(hiredate,4,2)='03';
	
--ex03_solution)
select empno,ename,hiredate 
	from emp 
	where  to_char(hiredate,'MM') in('01','02','03')
	
-- ex04) emp 테이블을 조회하여 이름이 'ALLEN' 인 사원의 사번과 이름과 연봉을 
--       출력하세요. 단 연봉은 (sal * 12)+comm 로 계산하고 천 단위 구분기호로 표시하세요.
--       7499 ALLEN 1600 300 19,500     
select empno,ename,to_char(sal*12+nvl(comm,0),'99,999')as 연봉  
from emp 
where ename='ALLEN';


-- ex05) professor 테이블을 조회하여 201 번 학과에 근무하는 교수들의 이름과 
--       급여, 보너스, 연봉을 아래와 같이 출력하세요. 단 연봉은 (pay*12)+bonus
--       로 계산합니다.
--       name pay bonus 6,970

select name,pay,bonus,to_char(pay*12+nvl(bonus,0),'99,999')as  연봉
from professor;
where deptno=201;

-- ex06) emp 테이블을 조회하여 comm 값을 가지고 있는 사람들의 empno , ename , hiredate ,
--       총연봉,15% 인상 후 연봉을 아래 화면처럼 출력하세요. 단 총연봉은 (sal*12)+comm 으로 계산하고 
--       15% 인상한 값은 총연봉의 15% 인상 값입니다.
--      (HIREDATE 컬럼의 날짜 형식과 SAL 컬럼 , 15% UP 컬럼의 $ 표시와 , 기호 나오게 하세요)
select empno,ename,to_char(hiredate,'yyyy.mm.dd'),to_char((sal*12)+nvl(comm,0),'$99,999') as 총연봉, to_char((sal*12+nvl(comm,0))*1.15,'$99,999') as "15%연봉인상"
from emp
where comm is not null;

-- ex07) Professor 테이블에서 201번 학과 교수들의 이름과 급여, bonus , 총 연봉을 출력하세요. 
--       단 총 연봉은 (pay*12+bonus) 로 계산하고 bonus 가 없는 교수는 0으로 계산하세요
select name,pay,bonus,to_char(pay*12+nvl(bonus,0),'99,999')as  총연봉
from professor;
where deptno=201;


-- ex08) 아래 화면과 같이 emp 테이블에서 deptno 가 30 번인 사원들을 조회하여 comm 값이 있을 경우
--       'Exist' 을 출력하고 comm 값이 null 일 경우 'NULL' 을 출력하세요 
select empno,ename,nvl2(comm,'Exist','Null')
from emp 
where deptno=30;


-- ex09) student 테이블에서 deptno1=101인 학생들의 이름과 전화번호와 블라인딩처리 
--			ex) 055)381-**** , 02)7777-**** 형식으로 출력
--9) instr   : 주어진 문자에서 특정문자의 위치를 리턴 : instr("A*B#C#D", '#') -> 4
					--instr(문자열, 찾는글자, 시작위치, 몇번째(기본값 1)): 찾는 문자의 위치를 리턴 //음수값은 뒤에서 부터 검색
	select 'A*B*C*D',instr('A*B*C*D','*') ,instr('A*B*C*D','*',1,3),instr('A*B*C*D','*',3,1),instr('A*B*C*D','*',3,2)from dual;
	select instr('HELLO World','O'),instr('HELLO World','o') from dual;

select name,tel,replace(tel,substr(tel,instr(tel,'-')+1,4),'****')
from student
where deptno1=101;


select name,
			deptno1, 
			decode(deptno1,101,'컴퓨터공학'),			--if(true){}
			decode(deptno1,101,'컴퓨터공학','기타학과') --if~else~
	from student;


select name, 
			decode(deptno1,101,'컴퓨터공학',
			decode(deptno1,102,'미디어융합',
			decode(deptno1,103,'소프트웨어융합','기타학과'))) as 학과명
from student;


select name, 
			decode(deptno1,101,'컴퓨터공학',
										 102,'미디어융합',
										 103,'소프트웨어융합','기타학과') as 학과명
from student;



--중첩 decode
--101 학과 교수중에 Aduie Murphy 교수는 Best Professor.
--101 이외의 담당교수 N/A 출력하기
select name,deptno from professor;

select name,
			deptno,
			decode(deptno,101,'Best Professor','N/A')
from professor;

select name,
			deptno,
			decode(deptno,101,
			decode(name,'Audie Murphy','Best Professor','Good Professor'),'N/A')
from professor;

-- 실습
-- ex01) student에서 전공(deptno1)이 101인 학생들 중에서 jumin에서
-- 1 or 3이면 '남자', 2 or 4면 '여자'로 출력
-- substr, decode
select name
     , jumin
       , '남자 or 여자'
  from student
 where deptno1 = 101;
 
 
 select * from student; 

select name, jumin,
			decode(substr(jumin,7,1),'1','남자','2','여자'), 
			decode(substr(jumin,7,1),'3','남자','4','여자')
from student
where deptno1=101;
 
-- ex02) Student 테이블에서 1 전공이 (deptno1) 101번인 학생의 이름과 
--       연락처와 지역을 출력하세요. 단,지역번호가 02 는 "SEOUL" , 
--       031 은 "GYEONGGI" , 051 은 "BUSAN" , 052 는 "ULSAN" , 
--       055 는 "GYEONGNAM"입니다. 


select name,tel,substr(tel,0,instr(tel,')')-1),
				decode(substr(tel,0,instr(tel,')')-1),02,'SEOUL',
																						031,'GYEONGGI',
																						051,'BUSAN',
																						052,'ULSAN',
																						055,'GYEONGNAM')
from student
where deptno1=101;



/*
	CASE 함수
	1) case 조건 when 결과 then true else false end as 별칭;
	2) case when between 값1 and 값2 then else false end as 별칭;

*/
select name,tel,substr(tel,0,instr(tel,')')-1),
				decode(substr(tel,0,instr(tel,')')-1),02,'SEOUL',
																						031,'GYEONGGI',
																						051,'BUSAN',
																						052,'ULSAN',
																						055,'GYEONGNAM'),
				case substr(tel,0,instr(tel,')')-1)	
					when '02' then 'SEOUL'	
					when '031' then 'GYEONGGI'
					when '051' then 'BUSAN'
					when '052' then 'ULSAN'
					when '055' then 'GYEONGNAM'
					else '기타'
					end as 지역번호
from student
where deptno1=101;


--2. case when between
--emp테이블에서 sal 1~1000 1등급, 1001~2000 2등급, 2001~3000 3등급, 3001~4000 4등급  4001보다 크면 5등급
select empno
			,ename
			,sal
			,case when sal between 1 and 1000 then '1등급'
						when sal between 1001 and 2000 then '2등급'
						when sal between 2001 and 3000 then '3등급'
						when sal between 3001 and 4000 then '4등급'
						when sal > 4001 then '5등급'
			end 급여등급
from emp;

select name,jumin,substr(jumin,3,2)
from student;

-- ex01) student에서 jumin에 월참조해서 해당월의 분기를 출력(1Q, 2Q, 3Q, 4Q)
-- name, jumin, 분기
select name,jumin,substr(jumin,3,2) as 해당월,
			case when substr(jumin,3,2) between 1 and 3 then '1Q'
					 when substr(jumin,3,2) between 4 and 6 then '2Q'
					 when substr(jumin,3,2) between 7 and 9 then '3Q'
					 else '4Q'
			end 분기
from student;

-- ex02) dept에서 10=회계부, 20=연구실, 30=영업부, 40=전산실
-- 1) decode
-- 2) case
-- deptno, 부서명

select *
from emp; 

select ename,deptno as 부서번호,
			case deptno when 10 then '회계부' 
									when 20 then '연구실' 
									when 30 then '영업부'
									when 40 then '전산실'  
				end 부서명
from emp;


-- ex03) 급여인상율을 다르게 적용하기
-- emp에서 sal < 1000 0.8%인상, 1000~2000 0.5%, 2001~3000 0.3%
-- 그 이상은 0.1% 인상분 출력
-- ename, sal(인상전급여), 인상후급여 
-- 1) decode
-- 2) case
-- 3) sign(sal-1000) 함수

select sign(-1),sign(0),sign(1) from dual;
--JS에서 객체 or 값을 비교할 때 -1,0,1

select *
from emp; 

select ename,sal,sal-1000 ,sign(sal-1000)
from emp;

select ename,sal as 인상전급여,
								decode(sign(sal-1000)
										 ,-1,sal*1.08,  --sal <1000
										 0,sal*1.05,  --sal==1000
											decode(sign(sal-2000)
												,-1,sal*1.05   --sal<2000
												,0,sal*1.05 		--sal==2000
													,decode(sign(sal-300)
															,-1,sal*1.03,				--sal<2000
															0,sal*1.03,  			--sal==2001
															1,sal*1.01				--sal>3000
																		 ))) as 인상후급여																	 
		 ,case when sal between 1 and 1000 then sal *1.08
					 when sal between 1001 and 2000 then sal *1.05
					 when sal between 2001 and 3000 then sal *1.03
				   when sal>3000 then sal *1.01
					 end 인상후급여
from emp;



