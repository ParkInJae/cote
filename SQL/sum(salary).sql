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

-- sql grant 문, revoke문 (권한과 관련된 내용)

-- 제약조건인 []부분은 사용자에게 grant를 부여 권한 o일 경우 작성, grant 부여 권한 x시에는 생략 가능하다.
1. GRANT문
grant 권한 on 테이블 to 사용자 [with grant option] ;

-- 예시 , A, B, C 3명의 사용자가 존재하고, A_table에 대한 권한을 A가 B에게 , B가 C에게 부여한다고 가정

-- 1. A 테이블에 대한 모든 권한을 B 사용자뿐만 아닌 다른 사용자에게 허용
GRANT ALL ON A_table TO B WITH GRANT OPTION ; 
-- 2. 모든 권한을 가진 B가 C에게 모든 권한을 부여 
GRANT ALL ON A_table TO C ;


2. REVOKE문 
-- CASCADE : 원래 권한을 회수할 때, 그 권한을 기반으로 다른 사용자에게 부여된 모든 권한(종속된 권한)도 함께 자동으로 회수.
-- RESTRICT : 종속된 권한이 존재하면 회수 작업이 실패하고 아무런 변경도 일어나지 않음.
revoke 권한 on 테이블 from 사용자 [cascade| restrict] ;




-- 예시 A,B,C가 존재한다고 가정, A가 B에게 권한을 주었고, B가 C에게 권한을 주었다.
-- 이때, CASCADE문과 RESTRICT문을 사용해 REVOKE문을 작성 후 해석 


-- cascade문을 사용해서 , B에게서 권한을 회수하면 b가 권한을 준 c의 권한도 같이 삭제된다.
REVOKE ALL ON A_table FROM B cascade ; -- B에게 권한을 받은 C의 권한도 같이 삭제 됨.

-- restrict의 경우 종속된 권한이 존재하면 회수 작업이 실패하고 기존 권한에서 변경이 발생하지 않기 때문에
-- restrict를 사용해서 revoke문을 실행해도 권한을 회수할 수 없다. 
REVOKE ALL on A_table FROM B restrict ; -- 기존 상태 유지 


