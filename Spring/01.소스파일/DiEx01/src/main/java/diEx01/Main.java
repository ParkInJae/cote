package diEx01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//A 타입 객체를 생성후
		//id에는 admin name에는 관리자 addr 백제대로 572
		//값을 대입해보세요.
		//생성된 객체를 담는 클래스 변수의 이름은 a 입니다.
		
		A a = new A(); //객체 생성
		a.setId("admin");
		a.setName("관리자");
		a.setAddr("백제대로 572");
		
		//-------------ioc 컨테이너 강제 동작-----------------
		
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationcontext.xml");
		//ioc 컨테이너가 생성한 객체는 ioc 컨테이넌에서 객체를 가지고 관리한다. 
		
		//ioc 컨테이너가 가지고 있는 a라는 이름의 bean을 A 타입으로 꺼내기
		A springA =ctx.getBean("a",A.class); 
		
		System.out.println("id::"+springA.getId());
		System.out.println("name::"+springA.getName());
		System.out.println("addr::"+springA.getAddr());
		
		/*
		 스프링 프레임워크에서 컨테이너가 객체를 생성하고 관리하기까지 과정
		 
		 1.객체 생성에 필요한 클래스를 개발자가 정의한다.
		 2.필요한 객체 생성 정보(설계도)를 개발자가 정의한다.
		 3.스프링 프레임워크 컨테이너가 설계도를 사용하여 객체를 생성 및 관리한다.
		 4.개발자는 컨테이너에서 필요한 객체를 호출하여 사용한다.
		  
		 */
		System.out.println("------------------------------------");
		//---------------개발자가 의존 주입 객체 생성------------------------
		
		B b = new B();
		b.setName("홍길동");
		b.setAge(20);
		
		C c = new C();
		c.setId("hong");
		c.setB(b); //setter 주입
		
		c.info();
		
		System.out.println("------------------------------------");
		//---------------spring ioc 컨테이너를 통한 의존 주입--------------------
		
		//ioc 컨테이너에 있는 springC 객체를 꺼내 info 메소드를 호출하기
		C springC = ctx.getBean("springC",C.class);
		
		springC.info();
		
		
	}

}








