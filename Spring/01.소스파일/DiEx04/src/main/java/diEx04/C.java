package diEx04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

	private A a;
	
	@Autowired
	public C(A a) {
		this.a= a;
	}
	
	public void method01() {
		System.out.println("C 클래스 호출 method01()!!");
		a.method01();
	}
	
	
}
