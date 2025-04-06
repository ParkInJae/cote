![image](https://github.com/user-attachments/assets/c9d080af-9b1d-4e7b-a036-cc45de789b8b)


<h1>
IN, ANY/SOME, ALL, EXISTS 와 같은 다중 행 연산자를 사용할 때,
 *서브쿼리의 결과값을 일종의 반복문처럼 각 메인 테이블의 행과 비교해서
조건이 참이면 true → 출력
거짓이면 false → 제외
</h1>


``` 
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
``` 

# exists 쿼리 적용 
slesect a.ID ,a.SALARY, a.TITLE
from EMP
where exists
(select 1
    from emp b
    where a.SALARY = b.SALARY
    and b.NAME='홍길동'
);

EMP 테이블의 첫 행의 SALARY 값부터 마지막 행의 SALARY 값까지 서브쿼리의 조건인 WHERE절의 a.SALARY의 값을 비교하여 일치할 경우 TRUE를 반환 후 출력하라는 의미를 가진다. 
**(요약하자면 홍길동과 급여가 같은 사람의 ID, SALARY, TITLE을 출력하라는 의미이다.)**

# all 쿼리 적용 
slesect a.ID ,a.SALARY, a.TITLE
from EMP
where SALARY > all
(select SALARY
    from emp
    where TITLE = '과장');

과장의 SALARY 값인 350과 400 보다 큰 값을 가진 데이터의 ID,SALARY, TITLE을 출력하라는 의미를 가진다.  

# any/some 쿼리 적용 
-- 사실상 any와 some은 쿼리가 같은 의미를 가진다. 
slesect a.ID ,a.SALARY, a.TITLE
from EMP
where SALARY > any
(select SALARY
from emp
where TITLE = '과장');

과장의 SALARY값인 350과400 중에서 한 가지보다 급여가 높을 경우 TRUE를 만족하며, 이때 TRUE의 값을 갖는 데이터의 ID, SALARY, TITLE을 출력하라는 의미를 가진다. 

<hr>

이해하기 어려웠던 이유 

나의 이해 : 1. 서브쿼리는 홍길동만 보니 결과도 홍길동만 나올 것이라고 생각하였다. 

           2. EXISTS는 서브쿼리의 반환 결과를 기준으로 필터링 

실제 작동 원리 : 1. 서브쿼리는 각 행마다 새로 실행되고, 홍길동과 급여가 같은지만 확인함
                
                2. EXISTS는 서브쿼리의 반환 결과를 기준으로 필터링 하되, 메인 행 기준으로 조건이 
                만족하는지 판단

<hr>
select 1 from 테이블명 where 조건

>  평소 select 칼럼 , from 테이블명 where 조건을 사용하다가 exists를 공부하면서, select 1에서 왜 1이 반환 되는지 이해가 가질 않았다. 

그래서 책을 다시 보고 이해하고 정리하였다. 

**select  칼럼 from 테이블명 where 조건; >> 테이블에서 조건에 맞는 데이터를 조회한 뒤 select문을 통해 칼럼과 그에 해당하는 튜플을 반환한다**

위의 원리를 적용해서 다시 생각해보면  아래의 코드는 자연스럽게 1을 반환하는 것이 맞다. 
```
select 1 from 테이블명 where 조건식;

```

위의 코드를 79번 라인의 bold체로 강조한 논리에 따르면, 테이블의 조건식에 맞는 데이터를 가져와 조회한 후 해당 튜플에 1을 반한하는것이 논리에 맞기 때문이다. 


<hr>
종합 정리 <br/>

![Image](https://github.com/user-attachments/assets/ba5a6e2d-5f3a-4006-a6d4-364ccb2837ac)








