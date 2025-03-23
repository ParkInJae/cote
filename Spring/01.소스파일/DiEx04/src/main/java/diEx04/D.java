package diEx04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class D {
	
	private B b;
	/*
	  @Autowired ������̼��� Ÿ���� �������� �����Ǵ� bean(��ü)�� �������� �����Ҽ� �ִ�.
	  �̶� Ÿ���� ���� bean�� ioc ���� ������ ������ �ִٸ� �ι�°�� �̸��� ���� bean�� �����Ѵ�.
	  
	  @Qualifier("��ü�̸�") ������̼��� ����ϸ� Ư�� bean�� �̸��� ������ �� ������
	  �����ڿ����� ����� �� ����.
	 */
	@Autowired
	public D(B b) {
		this.b=b;
	}
	
	public void method01() {
		System.out.println("------------------------");
		System.out.println("D Ŭ�������� method01() ȣ��");
		b.method01();
		System.out.println("------------------------");
	}
}
