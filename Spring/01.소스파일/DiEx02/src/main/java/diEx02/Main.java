package diEx02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 개발자가 생성자를 통하여 객체 생성하기
		
		A a = new A("홍길동","백제대로 572");
		
		System.out.println("name : "+a.getName());
		System.out.println("addr : "+a.getAddr());
		
		System.out.println("-----------------------------------");
		//스프링 ioc 컨테이너를 통하여 객체 생성후 사용하기
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationcontext.xml");
		
		
		A springA = ctx.getBean("springA",A.class);
		
		System.out.println("name : "+springA.getName());
		System.out.println("addr : "+springA.getAddr());
		
		System.out.println("---------------------------------");
		
		A a2 = new A("고길동","백제대로 555");
		
		B b = new B("gogildong", a2);//생성자 의존 주입 발생!!
		
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





