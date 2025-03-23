package aopEx01_target1;

import org.springframework.stereotype.Component;

@Component
public class A {
	
	public void method() {
		System.out.println("A 클래스 method의 핵심 로직입니다.");
	}
	
	public void method2() {
		System.out.println("A 클래스 method2의 핵심 로직입니다.");
	}
}
