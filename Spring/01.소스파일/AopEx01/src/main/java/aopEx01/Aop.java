package aopEx01;

import org.aspectj.lang.ProceedingJoinPoint;

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
public class Aop {

	//�ٽ� ���� ���� ���� ȣ�� �� ���� ���
	public void  beforeAdvice() {
		System.out.println("�ٽ� ���� ���� ���� ȣ��Ǵ� ������ �Դϴ�.");
	}
	
	public void afterAdvice() {
		System.out.println("�ٽ� ���� ���� �� ȣ��Ǵ� ���� ��� �Դϴ�.");
	}
	
	/*
	 2-1.after-throwing : �ٽɷ��� ���� �� �����߻� �� 
	 2-2.after-returning :  �ٽɷ��� ���� ���� �� 
	 */
	
	public void afterThrowingAdvice() {
		System.out.println("�ٽɷ����� ������ �߻��Ͽ� ���� �Ǿ����ϴ�.");
	}
	
	public void afterReturningAdvice() {
		System.out.println("�ٽɷ����� ���� ���� �Ǿ����ϴ�.");
	}
	
	
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










