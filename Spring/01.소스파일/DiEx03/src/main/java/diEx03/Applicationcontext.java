package diEx03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
  @Configuration ������̼��� �ִ� Ŭ������ ioc �����̳ʰ� 
  �о���̰� �Ǹ� �ش� Ŭ���� ��ü�� ������ �� @Bean ������̼��� �����ϴ� 
  ������ �޼ҵ带 ȣ���Ͽ�  bean �� ���� �� �����Ѵ�.
 */
@Configuration
public class Applicationcontext {
	
	@Bean
	public A a() {
		A obj = new A();
		obj.setName("ȫ�浿");
		obj.setAge("20");
		
		return obj;
	}
	
	public A a2() {
		A obj = new A();
		obj.setName("��浿");
		obj.setAge("30");
		
		return obj;
	}
}







