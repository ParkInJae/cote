package aopEx01_target1;

import org.springframework.stereotype.Component;

@Component
public class C {
	
	public void method01() throws Exception {
		System.out.println("Ŭ���� c method01 �ٽ� ���� ������");
		//System.out.println(10/0);
	}
}
