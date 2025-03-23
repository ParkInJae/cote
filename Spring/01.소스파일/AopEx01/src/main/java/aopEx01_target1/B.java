package aopEx01_target1;

import org.springframework.stereotype.Component;

@Component
public class B {
	
	public void method1() {
		System.out.println("클래스 B의 method1 핵심 로직 실행중입니다.");
	}
	
	public void method2() {
		System.out.println("클래스 B의 method2 핵심 로직 실행중입니다.");
	}
}
