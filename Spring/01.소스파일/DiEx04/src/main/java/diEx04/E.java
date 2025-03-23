package diEx04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class E {

	@Autowired
	private A a;
	
	private B bb;

	@Qualifier("objB")
	@Autowired
	public void setBb(B bb) {
		this.bb = bb;
	}
	
	public void method01() {
		System.out.println("--------------------");
		System.out.println("E 클래스 method01() 호출!!");
		a.method01();
		bb.method01();
		System.out.println("--------------------");
	}
	
}
