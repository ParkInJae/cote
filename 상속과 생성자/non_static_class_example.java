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
        A aa = nsce.new B(); 
        
        aa.AMethod();
        aa.overMethod();
         // aa.BMethod();



         //B bb = nsce.new A() // 블가능한 이유 
    }





}
