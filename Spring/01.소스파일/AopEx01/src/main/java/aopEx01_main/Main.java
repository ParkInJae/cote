package aopEx01_main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aopEx01_target1.A;
import aopEx01_target1.B;
import aopEx01_target1.C;
import aopEx01_target1.D;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		A a = new A();
		
		a.method();
		a.method2();
		
		System.out.println("-------------------------------------");
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationcontext.xml");
		
		a = ctx.getBean("a",A.class);
		a.method();
		a.method2();
		System.out.println("-------------------------------------");
		
		B b = ctx.getBean("b",B.class);
		b.method1();
		b.method2();
		System.out.println("-------------------------------------");
		
		C c = ctx.getBean("c",C.class);
		c.method01();
		
		System.out.println("-------------------------------------");
		D d = ctx.getBean("d",D.class);
		d.method();
		
	}

}







