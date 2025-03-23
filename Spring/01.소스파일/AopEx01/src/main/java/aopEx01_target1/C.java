package aopEx01_target1;

import org.springframework.stereotype.Component;

@Component
public class C {
	
	public void method01() throws Exception {
		System.out.println("클래스 c method01 핵심 로직 실행중");
		//System.out.println(10/0);
	}
}
