package diEx03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(Applicationcontext.class);
		
		A a = ctx.getBean("a",A.class);
		
		System.out.println("name:"+a.getName());
		System.out.println("age:"+a.getAge());
	}

}
