package diEx03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
  @Configuration 어노테이션이 있는 클래스를 ioc 컨테이너가 
  읽어들이게 되면 해당 클래스 객체를 생성한 후 @Bean 어노테이션이 존재하는 
  각각의 메소드를 호출하여  bean 을 생성 및 관리한다.
 */
@Configuration
public class Applicationcontext {
	
	@Bean
	public A a() {
		A obj = new A();
		obj.setName("홍길동");
		obj.setAge("20");
		
		return obj;
	}
	
	public A a2() {
		A obj = new A();
		obj.setName("고길동");
		obj.setAge("30");
		
		return obj;
	}
}







