public class A {
    // 클래스 A와 B가 내부(non-static)클래스가 아닌 경우 
            private String a = "문자열 a"; // 필드 선언 
    
            public A() { // 생성자 생성 
                System.out.println("A의 생성자 호출 ");
            }
    
            public void method_a(String name ){ // void로 인해 return 타입 생성 안해도 됨 
                System.out.println("method_a의 값" + a); 
            }
    
    
        class B extends A {
            private String b = "문자열 b";
    
            public B(){ // 생성자 생성 
                super();
                System.out.println("B의 생성자 호출");
            }
    
    
            public void method_b (String name ){
                System.out.println("method_b의 값" + b); 
            }
        }
    
    
    
        public static void main(String []args){
            String name  = "name";
            A a = new A();
            // B b = new A();
    
            a.method_a(name);
    
        }
}
