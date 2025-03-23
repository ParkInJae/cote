package diEx04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationcontext.xml");
		
		A a = ctx.getBean("a",A.class);
		
		a.method01();
		
		B b = ctx.getBean("objB",B.class);
		b.method01();
		
		C c = ctx.getBean("c",C.class);
		c.method01();
		
		D d = ctx.getBean("d",D.class);
		d.method01();
		
		E e = ctx.getBean("e",E.class);
		e.method01();
	}

}






