package diEx04;

import org.springframework.stereotype.Component;
/*
 ioc �����̳ʰ� @Component ������̼��� �ִ� Ŭ������
 �о� ��ü�� �����Ͽ� ���� ��.�̶� �����Ǵ� Ŭ���� ��ü�� �̸���
 Ŭ���� �� ù���� �ҹ��ڰ� �ȴ�.
 
 �ַ� �ش� Ŭ���� �����Ǵ� ��ü�� ������ �� �ʿ����
 �ϳ��� �ʿ��ϸ� ���� �ʵ� �� ������ ���� ��� ����Ѵ�.
 */
@Component
public class A {

	public void method01() {
		System.out.println("A Ŭ������ method01 ȣ��!");
	}
	
}
