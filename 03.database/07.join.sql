/* 
   Join 문법
    
    1. 표준문법
    
    select t1.col1, t2.col1
      from table1 t1, table2 t2
     where t1.col1 = t2.col1
      
    select table1.col1, table2.col1
      from table1 t1, table2 t2
     where table1.col1 = t07.joinable2.col1   
      
   2. ansi join
    select table1.col1, table2.col1
    from table1 a [inner] join table2 b on a.col1 = b.col1
   
*/

/
-- A. Inner Join
-- 1. catesian product
-- join대상이 누락되었을 때 모든 테이블들의 내용이 곱으로 출력된다.

select * from emp;
select * from dept;

select *
from emp,dept;

select * 
from dual,emp;

-- 2. Equi join(등가조인)

select ename, deptno from emp;
select deptno, dname from dept;

select ename,
			 dept.deptno
			 ,dname
from emp, dept
where emp.deptno=dept.deptno;


select emp.ename
			 ,dept.deptno
			 ,dname
from emp, dept
where emp.deptno=dept.deptno;


-- 테이블 별칭 부여_테이블 별칭 사용 시 테이블 실제 명 대신 테이블 별칭을 사용해야한다.

select e.ename,
			 d.deptno
			 ,d.dname
from emp e, dept d
where e.deptno=d.deptno;


-- ansi join
select e.ename,
			 d.deptno
			 ,d.dname
from emp e join dept d 
						on e.deptno=d.deptno;

select e.ename,
			 d.deptno
			 ,d.dname
from emp e inner join dept d 
						on e.deptno=d.deptno;

-- left join
select e.ename,
			 d.deptno
			 ,d.dname
from emp e left join dept d 
						on e.deptno=d.deptno;
						
-- right join
select e.ename,
			 d.deptno
			 ,d.dname
from emp e right join dept d 
						on e.deptno=d.deptno;

-- full [outer] join
select e.ename,
			 d.deptno
			 ,d.dname
from emp e full join dept d 
						on e.deptno=d.deptno;


-- 실습1) student professor를 join 학생이름과 교수이름을 출력
select * from student;
select * from professor;
select * from department;

select std.name as 학생명,pro.name as 교수명
from student std, professor pro where std.profno=pro.profno;


select std.name as 학생명 ,pro.name as 교수명
from student std join professor pro on std.profno=pro.profno;

-- 실습2) student와 department,professor를 join해서 학생이름과 학과 이름 교수이름을 출력
-- 표준일 경우 from 3개의 테이블, ansi일 경우 join이 두 번

-- 표준
select std.name as 학생명,pro.name as 교수명,dept.dname as 학과명
from student std, professor pro, department dept 
where std.profno=pro.profno and pro.deptno=dept.deptno;

-- ansi
select std.name as 학생명, pro.name as 교수명, dept.dname  as 학과명
from student std 
			join professor pro on std.profno=pro.profno
			join department dept on pro.deptno=dept.deptno;

--3. non-equi join(비등가조인)
--between,in..
select * from customer;
select * from gift;


--customer 와 gift를 join하여 고객별로 마일리지(point) 기준으로 선물을 받을 수 있는 선물세트를 조회
--고객명과 상품명을 출력하라
select cus.gname as 고객명, gft.gname as 상품명
from customer cus
		,gift gft
	where cus.point between  gft.g_start and gft.g_end;

select cus.gname as 고객명,cus.point as 포인트, gft.gname as 상품명
from customer cus
		,gift gft
	where gft.g_start <= cus.point and  cus.point <= gft.g_end;



--ansi join
select cus.gname as 고객명, gft.gname as 상품명
from customer cus
		join gift gft on cus.point between  gft.g_start and gft.g_end;

--실습 student, hakjum,score 테이블에서 학생명과 점수와 학점을 출력
select * from student;
select * from hakjum;
select * from score;

select std.name as 학생명, hak.grade as 학점 , scr.total as 점수
from student std, hakjum hak, score scr
where std.studno=scr.studno and hak.min_point <= scr.total and  scr.total <= hak.max_point;


select std.name as 학생명 , scr.total as 점수 ,hak.grade as 학점 
from student std join score scr on std.studno=scr.studno join hakjum hak on scr.total between hak.min_point and hak.max_point;


/*B. outer Join*/
--1.
--'(+)'는 oracle에서만 사용되는 outer join문법
select std.name 학생명, pro.name 교수명
from student std, professor pro
where std.profno=pro.profno; 		--해당결과 교수가정해지지 않은 학생이 누락되어 15명만 나오게 됨.(innerjoin)

select count(*) as 학생수 from student; --전체 학생수 20명
select * from student;

select name,profno from student where profno is null;

--(+)이 왼쪽에 정의 되어있으면 right_join 오른쪽에 정의 되어있으면 left_join
select std.name 학생명, pro.name 교수명
from student std, professor pro
where std.profno=pro.profno(+);  --left[outer] join  (20건)


select std.name 학생명, pro.name 교수명
from student std, professor pro
where std.profno(+)=pro.profno;	--right[outer] join  (22건)  담당학생이 없는 교수님까지 함께 조인되어 노출



--2. ansi join
select std.name 학생명, pro.name 교수명
from student std join professor pro on std.profno=pro.profno;  --inner


select std.name 학생명, pro.name 교수명
from student std left join professor pro on std.profno=pro.profno; --left_join


select std.name 학생명, pro.name 교수명
from student std right join professor pro on std.profno=pro.profno; 	--right[outer] join 



/*C. FULL JOIN*/

select std.name 학생명, pro.name 교수명
from student std full join professor pro on std.profno=pro.profno; --담당 교수가 없는 학생, 담당 학생이 없는 교수 모두 노출됨 (full join)

select std.name 학생명, pro.name 교수명
from student std full outer join professor pro on std.profno=pro.profno;

/*self join*/
select e.empno from emp e;
select m.mgr from emp m;

select e.empno
			,e.ename
			,e.mgr
			,m.ename
from emp e, emp m
where e.mgr=m.empno;



/* 연습문제 */
select * from student;
select * from department; 

-- ex01) student, department에서 학생이름, 학과번호, 1전공학과명출력
select std.name, dpt.deptno,dpt.dname
from student std, department dpt
where std.deptno1=dpt.deptno;

select std.name as 학생이름 ,dpt.deptno as 학과번호 ,dpt.dname as "1전공학과명"
from student std join department dpt on std.deptno1=dpt.deptno;

-- ex02) emp2, p_grade에서 현재 직급의 사원명, 직급, 현재 년봉, 해당직급의 하한
--       상한금액 출력 (천단위 ,로 구분)   
select * from emp2;
select * from p_grade;
select name,position from emp2 where position is null;

select  e.name as 사원명, 
				e.position as 직급,
				to_char(e.pay,'$999,999,999') as 현재연봉,
				to_char(pg.s_pay,'$999,999,999') as 해당직급하한금액,
				to_char(pg.e_pay,'$999,999,999') as 해당직급상한금액
from emp2 e, p_grade pg
where e.position=pg.position(+);


-- ex03) emp2, p_grade에서 사원명, 나이, 직급, 예상직급(나이로 계산후 해당 나이의
--       직급), 나이는 오늘날자기준 trunc로 소수점이하 절삭

select  e.name as 사원명, 
				e.position as 직급,
				trunc(months_between(sysdate,birthday)/12) as 나이,
				pg.position as 예상직급		
from emp2 e, p_grade pg
where  trunc(months_between(sysdate,birthday))/12 >= pg.s_age and trunc(months_between(sysdate,birthday))/12 <= pg.e_age;



select  e.name as 사원명, 
				e.position as 직급,
				trunc(months_between(sysdate,birthday)/12) as 나이,
				pg.position as 예상직급		
				from emp2 e
				join p_grade pg on trunc(months_between(sysdate,birthday))/12  between  pg.s_age and pg.e_age;

--select 	birthday, trunc(months_between(sysdate,birthday)/12)
--from emp2;

-- ex04) customer, gift 고객포인트보나 낮은 포인트의 상품중에 Notebook을 선택할
--       수 있는 고객명, 포인트, 상품명을 출력      

select * from customer;
select * from gift;

select cst.gname, cst.point, gft.gname
from customer cst, gift gft
where  cst.point<=gft.g_end and gft.gname='Notebook';


select cst.gname, cst.point, gft.gname
from customer cst
join gift gft on cst.point<=gft.g_end and gft.gname='Notebook';


-- ex05) professor에서 교수번호, 교수명, 입사일, 자신보다 빠른 사람의 인원수
--       단, 입사일이 빠른 사람수를 오름차순으로

select * from professor;

select prf1.profno as 교수번호 
			,prf1.name as 교수명
			,prf1.hiredate as 입사일
			,count(prf1.hiredate<prf2.hiredate)
from professor prf1, professor prf2
order by prf1.hiredate;

-- ex06) emp에서 사원번호, 사원명, 입사일 자신보다 먼저 입사한 인원수를 출력
--       단, 입사일이 빠른 사람수를 오름차순 정렬
select * from emp;

select e.empno as 사원번호
			,e.ename as 사원명
			,e.hiredate as 입사일
from emp e
order by e.hiredate;


















