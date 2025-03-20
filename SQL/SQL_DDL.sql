1. CREATE 문
테이블 생성 예시: employee_id,first_name,last_name,hire_date를 포함한 employees테이블을 생성하세요 
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    hire_date DATE
);

설명:  CREATE TABLE 테이블명 (
        칼럼명 타입,
        칼럼명 타입,
        칼럼명 타입
    );  
위와 같은 형태로 이루어져있음 

* employee_id 컬럼은 정수형(INT)으로 기본키(Primary Key)로 지정되어 중복되지 않는 유일한 값이 들어가야 합니다.
first_name과 last_name은 각각 최대 50자의 문자열을 저장합니다.
hire_date는 날짜형(DATE) 컬럼입니다.


VIEW(뷰)::  실제 데이터를 저장하지 않고, SELECT 쿼리 결과를 저장하는 가상의 테이블입니다.

뷰(View) 생성 예시: employees 테이블에서 employee_id, first_name, last_name 컬럼을 선택하여 뷰를 구성.



 = > CREATE VIEW employee_names AS
    SELECT employee_id, first_name, last_name   
    FROM employees;

설명: CREATE View 뷰이름 AS SELECT 칼럼명 FROM 테이블명 [where (조건이 있을시 사용 )] 형태로 이루어져있음




2. ALTER 문
테이블 구조 변경 예시 (컬럼 추가): employees 테이블에 ADD 키워드를 사용하여 새로운 컬럼 email을 추가하세요 이때 email 컬럼은 100자의 문자열을 저장할 수있습니다. 
ALTER TABLE employees
ADD email VARCHAR(100);

설명: VARCHAR(100)은 최대 100자의 문자열을 저장할 수 있습니다.

테이블 구조 변경 예시 (컬럼 수정): employees 테이블의 hire_date 컬럼의 데이터 타입을 DATE에서 DATETIME으로 변경하세요.
ALTER TABLE employees
MODIFY hire_date DATETIME;

설명: 이 구문은 사용하는 데이터베이스 종류에 따라 문법이 다를 수 있으므로(MySQL과 Oracle, PostgreSQL 등), 사용 중인 RDBMS의 문서를 참고해야 합니다.

3. RENAME 문
테이블 이름 변경 예시 (MySQL의 경우): employees 테이블의 이름을 staff로 변경합니다.
RENAME TABLE employees TO staff;
설명:
MySQL에서는 RENAME TABLE 구문을 사용하며, 동시에 여러 테이블의 이름을 변경할 수도 있습니다.

PostgreSQL의 경우 (ALTER TABLE 사용):
ALTER TABLE employees
RENAME TO staff;
설명: PostgreSQL에서는 ALTER TABLE과 함께 RENAME TO 구문을 사용하여 테이블 이름을 변경합니다.


4. DROP 문
테이블 삭제 예시: staff라는 테이블을 삭제해주세요 
DROP TABLE staff;
설명: 위 구문은 staff 테이블을 데이터베이스에서 완전히 삭제하며, 이때 삭제된 텡블의 데이터와 구조는 복구할 수 없으므로 주의해야 합니다.

뷰 삭제 예시: employees_names 라는 뷰를 삭제해주세요 
DROP VIEW employee_names;
설명: 이 구문은 employee_names 뷰를 데이터베이스에서 삭제하나, 뷰는 실제 데이터를 저장하지 않으므로, 삭제 시 데이터 손실 문제는 발생하지 않음 


요약
CREATE: 새 테이블이나 뷰를 생성합니다.
ALTER: 기존 테이블의 구조(컬럼 추가, 수정, 삭제 등)를 변경합니다.
RENAME: 테이블이나 뷰의 이름을 변경합니다.
DROP: 테이블이나 뷰를 데이터베이스에서 완전히 삭제합니다.
이 예제들은 다양한 데이터베이스 관리 시스템(RDBMS)에 따라 문법에 차이가 있을 수 있으므로, 실제 환경에서는 해당 DBMS의 공식 문서를 참고하여 사용해야함