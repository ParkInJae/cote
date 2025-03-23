package diEx04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class D {
	
	private B b;
	/*
	  @Autowired 어노테이션은 타입을 기준으로 생성되는 bean(객체)의 의존성을 주입할수 있다.
	  이때 타입이 같은 bean을 ioc 에서 여러개 가지고 있다면 두번째로 이름이 같은 bean을 주입한다.
	  
	  @Qualifier("객체이름") 어노테이션을 사용하면 특정 bean의 이름을 지정할 수 있으나
	  생성자에서는 사용할 수 없다.
	 */
	@Autowired
	public D(B b) {
		this.b=b;
	}
	
	public void method01() {
		System.out.println("------------------------");
		System.out.println("D 클래스에서 method01() 호출");
		b.method01();
		System.out.println("------------------------");
	}
}
