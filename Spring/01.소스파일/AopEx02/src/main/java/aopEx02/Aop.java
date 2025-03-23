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
* ���� Ŭ������ �������� ���� ���(�޼ҵ�)�� �����ϴ� Ŭ����  
 
* aop ���� ���� ���ɻ� ���� Ŭ������ �з� ��ɵ��� �޼ҵ�� �����ϰ� �ȴ�.
 
* aop ���α׷����� �ϱ� ���ؼ��� aspect�� target ���� ioc �����̳ʰ� ������
��ü �� ������ ������ �����ϴ�.
 
<aop ��� ����>
1. aspect : ���ɻ��� �ǹ̷� ���� ���ɻ纰 �������� ��� �ִ� �׷� �Ǵ� Ŭ������ �ǹ��Ѵ�. 
2. target : aspect�� ������ Ŭ���� �Ǵ� �޼ҵ带 �ǹ���
3. advice : ���������� � ���� �ؾ��� ���� ���� ������ �ΰ� ����� ���� ����ü 
4. joinpoint : �������� ����Ǿ���ϴ� �ٽ� ����� ����
5. pointcut : joinpoint�� ���� ������ �ǹ�
 
 */

@Aspect
@Component
public class Aop {

	//�ٽ� ���� ���� ���� ȣ�� �� ���� ���
	@Before("within(��Ű����.Ŭ����)")
	public void  beforeAdvice() {
		System.out.println("�ٽ� ���� ���� ���� ȣ��Ǵ� ������ �Դϴ�.");
	}
	
	@After("within(��Ű����.Ŭ����)")
	public void afterAdvice() {
		System.out.println("�ٽ� ���� ���� �� ȣ��Ǵ� ���� ��� �Դϴ�.");
	}
	
	/*
	 2-1.after-throwing : �ٽɷ��� ���� �� �����߻� �� 
	 2-2.after-returning :  �ٽɷ��� ���� ���� �� 
	 */
	@AfterThrowing("within(��Ű����.Ŭ����)")
	public void afterThrowingAdvice() {
		System.out.println("�ٽɷ����� ������ �߻��Ͽ� ���� �Ǿ����ϴ�.");
	}
	
	@AfterReturning("within(��Ű����.Ŭ����)")
	public void afterReturningAdvice() {
		System.out.println("�ٽɷ����� ���� ���� �Ǿ����ϴ�.");
	}
	
	@Around("within(��Ű����.Ŭ����)")
	public Object aroundAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("�ٽɷ��� ������");
		try {
			System.out.println("�ٽɷ��� ������2");
			
			Object obj = joinpoint.proceed();//�ٽɷ��� ����
			return obj;
			
		} finally {
			
			System.out.println("�ٽɷ��� ���� ��");
		}
	}
	
	
	
}










