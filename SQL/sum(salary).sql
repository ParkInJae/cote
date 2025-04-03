-- 수제비 모의고사 5회 오류 내용 
-- 정답
select 부서, sunm(급여)as 급여합계
from 급여
group by 부서 
having sum (급여) >=6000;


-- 해설지의 잘못된 답 
select 부서, sunm(급여)as 급여합계
from 급여
group by 부서 
having 급여합계 >=6000;

-- sql 읽는 순서 
from - where - group by , Having , select , order by  순서를 가지기 때문에 
해설지와 같이 작성하면 having에서는 급여합계가 정의되지 않았기에 에러가 발생한다. 

