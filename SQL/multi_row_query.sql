
-- 테이블 형태 
-- SQL
-- IN, ANY/SOME, ALL, EXISTS 와 같은 다중 행 연산자를 사용할 때,
--  *서브쿼리의 결과값을 일종의 반복문처럼 각 메인 테이블의 행과 비교해서
-- 조건이 참이면 true → 출력
-- 거짓이면 false → 제외

[ EMP ]
ID 	NAME	 SALARY     TITLE
101	김철수	  450       팀장
102	홍길동	  400       과장
103	장보고    350       과장
104	이순신    300       사원
105	유관순    250       사원
106	박영희    500       팀장
107	허준      400       과장
108	정약용    350       과장
109	스티브    300       사원

-- exists 쿼리 적용 
slesect a.ID ,a.SALARY, a.TITLE
from EMP
where exists
(select 1
    from emp b
    where a.SALARY = b.SALARY
    and b.NAME='홍길동'
);
> 홍길동

-- all 쿼리 적용 
slesect a.ID ,a.SALARY, a.TITLE
from EMP
where SALARY > all
(select SALARY
    from emp
    where TITLE = '과장');



-- any/some 쿼리 적용 
-- 사실상 any와 some은 쿼리가 같은 의미를 가진다. 
slesect a.ID ,a.SALARY, a.TITLE
from EMP
where SALARY > any
(select SALARY
from emp
where TITLE = '과장');

