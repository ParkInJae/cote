package aopEx01_target1;

import org.springframework.stereotype.Component;

@Component
public class D {

	public void method() {
		System.out.println("클래스 D method 핵심로직 실행중...");
	}
}
