package diEx04;

import org.springframework.stereotype.Component;
/*
 ioc 컨테이너가 @Component 어노테이션이 있는 클래스를
 읽어 객체로 생성하여 관리 함.이때 생성되는 클래스 객체의 이름은
 클래스 명 첫글자 소문자가 된다.
 
 주로 해당 클래스 생성되는 객체가 여러개 일 필요없이
 하나만 필요하며 내부 필드 가 별도로 없는 경우 사용한다.
 */
@Component
public class A {

	public void method01() {
		System.out.println("A 클래스의 method01 호출!");
	}
	
}
