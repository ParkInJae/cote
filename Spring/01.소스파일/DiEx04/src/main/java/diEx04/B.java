package diEx04;

import org.springframework.stereotype.Component;

@Component(value="objB")
public class B {

	public void method01() {
		System.out.println("B 클래스의 method01 호출입니다.");
	}
}
