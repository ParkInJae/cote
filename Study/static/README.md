<h1>static 개념 보충 </h1>
<h2>정의 </h2>

1.  static

**1-1 static 변수는 클래스에 속하는 변수로, 클래스가 메모리에 로드될 때 단 한 번 초기화됨.**

**1-2 모든 인스턴스가 이 변수의 같은 메모리 공간을 공유하기 때문에, 어느 인스턴스에서든 변수의 값이 변경되면 그 변경된 값이 다른 모든 인스턴스에서도 반영됨.**

특징

<h3>초기화 한 번: 클래스 로드 시점에 단 한 번만 초기화되므로, 이후 어떤 메소드가 호출되더라도 초기화되지 않음.</h3>

<h3>공유 변수: 모든 인스턴스가 static 변수의 동일한 값을 사용하기에, 공통 데이터 또는 카운터(객체 생성시 숫자를 증가시키는 클래스)와 같은 기능을 구현할 때 유용</h3>

<h3>메모리 관리: 인스턴스 변수와 달리, 인스턴스가 생성될 때마다 새로운 메모리 공간이 할당되지 않고, 클래스 단위로 하나의 메모리 공간만 사용.</h3>

```
// 예시 1
public class static_example {

    static  int count = 0;  // static 선언 

    public void method(){
        count++;
        System.out.print(count + " ");
    }

    public static void main(String[] args) throws Exception {
     
        static_example st = new static_example();
        st.method();
        st.method();
        st.method();
        
    }


}

```
<h2>이 코드의 값이 1 2 3 이나오는 이유</h2>
<h3>static int count = 0; 문장은 클래스가 메모리에 로드될 때 단 한 번 실행됩니다.
그래서 main() 메소드 내에서 st.method()를 호출할 때마다 count가 새로 초기화되지 않고, 이전 값이 그대로 유지되며 증가합니다.</h3>


<hr>
<h1>지역 변수와 정적 변수가 같이 존재할 때 <h1>

```
public class static_example {


    static  int count = 0;  // static 선언 

    public void method(){
        int count =0;
        count++;
        System.out.print(count + " ");
    }


    public static void main(String[] args) throws Exception {
        static_example st = new static_example();
        st.method();
        st.method();
        st.method();

        
    }
}
```

<h2>이 코드의 값이 1 1 1 이 나오는 이유</h2>
<h3>static_example가 메모리에 로드 되며 static 선언</h3>
<h3>main 함수에서 객체 생성 및 선언 후 객체의 메소드 선언</h3>
<h3>main에서 st.method를 선언시 내부 지역 변수 count를 호출하며, count는 호출 될 때마다 0값으로 초기화</h3>
<h3>따라서 st.method()가 끝나면 결과 값은 1이지만  st.method() 선언할 때마다 내부에서 count를 1로 초기화 하기 때문에 1만 출력이 된다.</h3>