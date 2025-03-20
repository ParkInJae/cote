public class non_static_class_example { // non-static 클래스 
    /*
     non-static 클래스 >> 내부 클래스이며 자바 클래스 내부에서 정의된 클래스를 의미함
     인스턴스 내부 클래스라고 불리기도 함 

     */
    class A{ // 내부 클래스 생성 
 
         public A(){ // 기본 생성자 
            System.out.println("A의 생성자 호출");
        }

        public void AMethod(){
            System.out.println("A의 메소드 실행");
        }
        public void overMethod(){
            System.out.println("A의 오버라이딩전 메소드");
        }
    }


    class B extends A{
        public B(){
            super();
            System.out.println("B의 생성자 호출");
            
        }


        public void BMethod(){
            System.out.println("B의 메소드 실행");
        }

        public void overMethod(){
            System.out.println("A의 메소드를 오버라이딩한 B 메소드");
        }
    }


    public static void main(String []args){
        /*
         내부 클래스는 외부 클래스의 인스턴스와 연결되어 있다. 
         즉 내부 클래스의 객체를 생성하려면 먼저 외부 클래스의 객체가 필요하다. 
         >> 외부 클래스와 관련된 기능을 내부 클래스로 분리하여 외부에 노출할 필요 없음 ( 캡슐화 실행 )
         */

        /* 
          외부 클래스 > 내부 클래스 > 내부 클래스의 메소드 실행 
        */ 
        non_static_class_example nsce = new non_static_class_example();  // 외부 클래스 선언
       
        


// 부모 타입인 자식 타입 선언         
        B b =nsce.new B();    // 내부 클래스를 선언하기 위해 외부 클래스 변수의 .을 이용해서 선언 
        b.BMethod();  // 자식인 B 타입이 본인의 메소드를 사용 
        b.AMethod(); // 자식인 B 타입이 부모인 A타입의 메소드를 사용 
        b.overMethod(); // 자식인 B 타입이 부모의 메소드를 오버라이딩

  

// 부모타입인 A 타입 선언

        A a1 = nsce.new B();   // 내부 클래스를 선언하기 위해 외부 클래스 변수의 .을 이용해서 선언 

        a1.AMethod(); // 부모인 A타입의 a1 변수가 본인의 메소드를 사용
        a1.overMethod();  // 부모인 A타입의 a1 변수가 본인의 메소드를 사용
        // a1.BMethod();  // 부모인 A타입은 자식 타입을 참조할 수 없기 때문에 BMethod()를 참조할 수 업음





        
// 1. 부모 타입 변수 = new 자식 타입(); (O, 정상 작동)
 /*
 	B타입은 A타입을 상속 받아 A와 B의 필드와 메소드 전부를 사용할 수 있음
	 따라서 A 타입이 B 타입을 참조해도 A타입의 고유 필드와 메소드를 사용할 수 있기 때문에 에러가 발생하지 않음
 */
        A aa = nsce.new B(); 
        
        aa.AMethod();
        aa.overMethod();
         // aa.BMethod();



         // B bb = nsce.new A() // 블가능한 이유 
/*
     B타입은 A타입을 받아 A와 B의 필드와 메소드 전부를 사용할 수 있음
     그러나 B타입이 A타입을 참조하는 형태로 객체를 생성할 경우 A타입의 고유 필드와 메소드는 사용할 수 있지만
    본인타입 (B타입)의 고유 필드와 메소드를 사용할 수 없기 때문에 위의 객체 생성 및 생성자 호출은 불가능하다.
 */
    }





}
