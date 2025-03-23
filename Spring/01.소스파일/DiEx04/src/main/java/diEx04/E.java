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
		System.out.println("E Ŭ���� method01() ȣ��!!");
		a.method01();
		bb.method01();
		System.out.println("--------------------");
	}
	
}
