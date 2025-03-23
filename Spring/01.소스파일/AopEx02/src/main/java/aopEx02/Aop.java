package aopEx02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
* 현재 클래스는 여러가지 공통 모듈(메소드)을 관리하는 클래스  
 
* aop 사용시 공통 관심사 별로 클래스를 분류 기능들을 메소드로 관리하게 된다.
 
* aop 프로그래밍을 하기 위해서는 aspect과 target 전부 ioc 컨테이너가 생성한
객체 들 끼리만 적용이 가능하다.
 
<aop 용어 정리>
1. aspect : 관심사라는 의미로 같은 관심사별 공통모듈을 담고 있는 그룹 또는 클래스를 의미한다. 
2. target : aspect을 적용할 클래스 또는 메소드를 의미함
3. advice : 실질적으로 어떤 일을 해야할 지에 대한 것으로 부가 기능을 담을 구현체 
4. joinpoint : 공통기능이 적용되어야하는 핵심 기능의 시점
5. pointcut : joinpoint의 상세한 스펙을 의미
 
 */

@Aspect
@Component
public class Aop {

	//핵심 로직 실행 전에 호출 될 공통 모듈
	@Before("within(패키지명.클래스)")
	public void  beforeAdvice() {
		System.out.println("핵심 로직 실행 전에 호출되는 공통모듈 입니다.");
	}
	
	@After("within(패키지명.클래스)")
	public void afterAdvice() {
		System.out.println("핵심 로직 실행 후 호출되는 공통 모듈 입니다.");
	}
	
	/*
	 2-1.after-throwing : 핵심로직 실행 시 에러발생 후 
	 2-2.after-returning :  핵심로직 정상 종료 후 
	 */
	@AfterThrowing("within(패키지명.클래스)")
	public void afterThrowingAdvice() {
		System.out.println("핵심로직이 에러가 발생하여 종료 되었습니다.");
	}
	
	@AfterReturning("within(패키지명.클래스)")
	public void afterReturningAdvice() {
		System.out.println("핵심로직이 정상 종료 되었습니다.");
	}
	
	@Around("within(패키지명.클래스)")
	public Object aroundAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("핵심로직 실행전");
		try {
			System.out.println("핵심로직 실행전2");
			
			Object obj = joinpoint.proceed();//핵심로직 실행
			return obj;
			
		} finally {
			
			System.out.println("핵심로직 실행 후");
		}
	}
	
	
	
}










