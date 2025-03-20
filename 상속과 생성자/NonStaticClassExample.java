public class NonStaticClassExample { // 외부 클래스

    // 인스턴스 내부 클래스 (non-static 내부 클래스)
    class A {  
        public A() { 
            System.out.println("A의 생성자 호출");
        }

        public void AMethod() {
            System.out.println("A의 메소드 실행");
        }

        public void overMethod() {
            System.out.println("A의 오버라이딩 전 메소드");
        }
    }

    class B extends A {
        public B() {
            super();
            System.out.println("B의 생성자 호출");
        }

        public void BMethod() {
            System.out.println("B의 메소드 실행");
        }

        @Override
        public void overMethod() {
            System.out.println("A의 메소드를 오버라이딩한 B 메소드");
        }
    }

    public static void main(String[] args) {
        NonStaticClassExample nsce = new NonStaticClassExample(); // 외부 클래스 객체 생성

        // (1) 부모 타입 변수 = new 자식 타입() (O, 정상 작동)
        A a = nsce.new B();  
        a.AMethod();    
        a.overMethod();  // 동적 바인딩으로 B의 메소드 실행

        // (2) 자식 타입 변수 = new 자식 타입() (O, 가능하지만 권장되지 않음)
        B b = nsce.new B(); 
        b.BMethod();  // 자식 클래스의 메소드 실행
        b.AMethod();  // 부모 메소드 실행 가능
        b.overMethod();  // 오버라이딩된 메소드 실행

        // (3) 잘못된 코드 예시
        // B bb = nsce.new A(); // (🚫) 불가능: A 객체는 B의 기능을 포함하지 않음.
    }
}
