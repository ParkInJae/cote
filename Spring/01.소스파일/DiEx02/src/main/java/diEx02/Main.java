package diEx02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// �����ڰ� �����ڸ� ���Ͽ� ��ü �����ϱ�
		
		A a = new A("ȫ�浿","������� 572");
		
		System.out.println("name : "+a.getName());
		System.out.println("addr : "+a.getAddr());
		
		System.out.println("-----------------------------------");
		//������ ioc �����̳ʸ� ���Ͽ� ��ü ������ ����ϱ�
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationcontext.xml");
		
		
		A springA = ctx.getBean("springA",A.class);
		
		System.out.println("name : "+springA.getName());
		System.out.println("addr : "+springA.getAddr());
		
		System.out.println("---------------------------------");
		
		A a2 = new A("��浿","������� 555");
		
		B b = new B("gogildong", a2);//������ ���� ���� �߻�!!
		
		System.out.println("id:"+b.getId());
		System.out.println("name : "+b.getA().getName());
		System.out.println("addr : "+b.getA().getAddr());
		
		System.out.println("---------------------------------");
		
		B springB = ctx.getBean("b",B.class);
		System.out.println("id:"+springB.getId());
		System.out.println("name : "+springB.getA().getName());
		System.out.println("addr : "+springB.getA().getAddr());
	}

}





