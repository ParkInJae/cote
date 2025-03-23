package diEx01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//A Ÿ�� ��ü�� ������
		//id���� admin name���� ������ addr ������� 572
		//���� �����غ�����.
		//������ ��ü�� ��� Ŭ���� ������ �̸��� a �Դϴ�.
		
		A a = new A(); //��ü ����
		a.setId("admin");
		a.setName("������");
		a.setAddr("������� 572");
		
		//-------------ioc �����̳� ���� ����-----------------
		
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationcontext.xml");
		//ioc �����̳ʰ� ������ ��ü�� ioc �����̳Ϳ��� ��ü�� ������ �����Ѵ�. 
		
		//ioc �����̳ʰ� ������ �ִ� a��� �̸��� bean�� A Ÿ������ ������
		A springA =ctx.getBean("a",A.class); 
		
		System.out.println("id::"+springA.getId());
		System.out.println("name::"+springA.getName());
		System.out.println("addr::"+springA.getAddr());
		
		/*
		 ������ �����ӿ�ũ���� �����̳ʰ� ��ü�� �����ϰ� �����ϱ���� ����
		 
		 1.��ü ������ �ʿ��� Ŭ������ �����ڰ� �����Ѵ�.
		 2.�ʿ��� ��ü ���� ����(���赵)�� �����ڰ� �����Ѵ�.
		 3.������ �����ӿ�ũ �����̳ʰ� ���赵�� ����Ͽ� ��ü�� ���� �� �����Ѵ�.
		 4.�����ڴ� �����̳ʿ��� �ʿ��� ��ü�� ȣ���Ͽ� ����Ѵ�.
		  
		 */
		System.out.println("------------------------------------");
		//---------------�����ڰ� ���� ���� ��ü ����------------------------
		
		B b = new B();
		b.setName("ȫ�浿");
		b.setAge(20);
		
		C c = new C();
		c.setId("hong");
		c.setB(b); //setter ����
		
		c.info();
		
		System.out.println("------------------------------------");
		//---------------spring ioc �����̳ʸ� ���� ���� ����--------------------
		
		//ioc �����̳ʿ� �ִ� springC ��ü�� ���� info �޼ҵ带 ȣ���ϱ�
		C springC = ctx.getBean("springC",C.class);
		
		springC.info();
		
		
	}

}








