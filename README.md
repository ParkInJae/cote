# 프로그래머스 LV1 처음 도전 
<br/>
<br/>

1. Caesar_cipher.java >> 시저 함수 <br/> 
<br/>

2. countDown >> 배열에 담긴 start_num부터 end_num까지 큰 순서대로 뽑기  <br/>
ex: 10, 9, 8, 7, 6 과 같은 형태로  <br/>
<br/>

3. EffectiveDivisor >> 빅오(O√n)효과적인 약수 구하기 <br/>
<br/>

4. FindDivisor >> 약수 찾기 <br/>
<br/>

5. Number_of_divisors_and_addition >> 전체를 돌면서 약수를 구하며 약수의 개수가 짝수이면 숫자를 더하고 홀수이며 해당 숫자를 전체에서 빼는 계산 <br/>
<br/>

6. StringChangeInteger >> 문자열을 int로 변환  <br/>
// Integer.parseInt는 문자열의 부호를 포함해서 정수로 변환한다 (+ , -) <br/>
<br/>

7. Weapon_Kg >> 사람, 공격력, 공격력 제한, 공격력에 따른 총 필요한 철의 kg 
<br/>

8. for (int i = 1; i * i <= number; i++)은 시간 복잡도 {빅오 표시법의 O(√n)} 알고리즘을 이용하며 특정한 정수의 약수를 구하는데 사용된다. 
  for (int i = 1; i * i <= number; i++) 로 for문의 조건을 작성한다면
   number의 제곱근까지 i 가 증가하며 number의 전체 약수를 구하는 것으로 볼 수 있다.

 -- 예시 ) 만약 정수 n에 대해서 약수를 구할 때  시간 복잡도를 이용해서 계산한다고 가정

8-1)  int sqrt = (int)Math.sqrt(n);  // n의 제곱근을 구함 
//O(√n) 를 이용하기 때문에 sqrt를 이용해서 제곱근을 얻어옴
            for (int i = 1; i <= sqrt; i++) {  }

8-2)  
//O(√n) 를 이용하기 때문에 sqrt를 이용해서 제곱근을 얻어옴
            for (int i = 1; i * i <= n ; i++) {}

# 오답 노트 
-- 기존 로직 
-> 주석을 통해 틀린 부분 작성 
 int count = 0;
        for(int i =1;  i*i <= number; i++){  // -> 이 부분은 하나의 정수의 약수를 효율적으로 구하기 위한 알고리즘
            // 즉 전체를 순히하는 것이 아닌 단 하나의 정수에 대한 약수를 계산함

            count = 0; // count를 0으로 초기화하여 올바른 누적 계산이 불가능함 
            if(number % i == 0){  // 제곱근 구할 때 
                count++;
            }else if(i != number / i){ // 일반 약수일 때 약수는 2개
                count++;  // 일반 약수는 한 쌍을 이뤄 2개이므로 count는 2개를 더해줘야함
            }
        }

        // power에 해당하는 무게 구하기 
        if (count <= limit){
            power += count;
        }else {
            power += 2;
        }
        int answer +=power;

        return answer;

-- 수정 로직 
    int totalWeight = 0; //  공격력에 대한 무게 
        
        for (int n = 1; n <= number; n++) {
            int count = 0;
            int sqrt = (int)Math.sqrt(n); //O(√n) 를 이용하기 때문에 sqrt를 이용해서 제곱근을 얻어옴
            for (int i = 1; i <= sqrt; i++) {    // for (int i = 1; i * i<= num; i++) { 과 같은 코드임 
                if (n % i == 0) {
                    // 약수가 하나라면 (제곱수인 경우)
                    if(i * i == n)  // 제곱근일 때 
                        count++;
                    else
                        count += 2;  // 일반 약수일 때 
                }
            }
            
            // 무기 공격력 결정: 제한수치 초과하면 정해진 power 사용
            if (count > limit)
                totalWeight += power;
            else
                totalWeight += count;
        }
        
        return totalWeight;
 
 <hr>

# 자바 상속 및 non-static 클래스 설명 

1. 상속 
부모 타입으로 자식 객체를 참조할 경우 
>> 부모 타입 변수는 선언된 타입에 포함된 메소드만 호출할 수 있으므로, 자식 클래스에서 새로 추가한 메소드(예: BMethod())는 호출할 수 없음.

<hr>
<h3>2. 그동안 헷갈렸던 객체 생성 시점의 메모리 구조와 타입 변환 개념 </h3>

<h2>2-1) 부모 타입 변수 = new 자식 타입(); (O, 정상 작동) </h2>

```
A a = new B();
```

✔️ 정상적으로 작동하는 이유

-- B 클래스는 A 클래스를 상속받았기 때문에, B 객체는 A의 특성을 모두 포함하고 있다.

-- 즉, B는 A로부터 모든 필드와 메소드를 상속받아 확장한 것이므로, B는 A처럼 동작할 수 있다.

-- 따라서, B 객체를 A 타입의 변수로 참조할 수 있다.

-- 하지만, a 변수의 타입이 A이므로, A에 정의된 메소드만 호출 가능하다.

-- 오버라이딩된 메소드가 있다면 동적 바인딩(dynamic binding)에 의해 자식 클래스의 메소드가 호출된다.

 # 힙과 스택을 통해 알 수 있는 메모리 구조 
1️⃣ 부모 타입 변수 = new 자식 타입 (A a = new B();)

```
    A a = new B();
```

🖥 메모리 구조

```

[Stack]                          [Heap]
-------------------------------------------------
a (A 타입)  --->   (B 객체: A 부분 + B 부분)

```

a는 Stack 영역에 저장되며, Heap 영역의 B 객체를 참조.
하지만 a의 타입이 A이므로, A에 선언된 필드와 메소드만 사용 가능함.
만약 B가 A의 메소드를 오버라이딩했다면, B의 메소드가 실행됨 (동적 바인딩).

✅ 호출 가능

```
a.AMethod();    // A에 정의된 메소드이므로 호출 가능
a.overMethod(); // B에서 오버라이딩한 메소드가 실행됨
```

❌ 호출 불가능

```
a.BMethod(); // 컴파일 오류! A 타입 변수는 B의 고유한 메소드 호출 불가능
```


<h2>2-2) 자식 타입 변수 = new 부모 타입(); (X, 컴파일 오류) </h2>

```
B b = new A();  // 오류 발생!
```

❌ 에러가 발생하는 이유

-- A는 B보다 상위 개념이므로, A 객체에는 B의 필드와 메소드가 포함되지 않는다.

-- 즉, A는 B보다 "작은 개념"이며, B가 가지고 있는 추가적인 기능(BMethod() 등)을 포함하지 않는다.

-- 하지만, B 타입 변수는 B에 있는 모든 필드와 메소드를 사용할 수 있어야 한다.

-- 그런데 A 객체를 B 타입 변수에 저장하면 B에 있는 추가적인 필드나 메소드를 사용할 수 없는 객체를 B라고 부르는 것이므로, 논리적으로 말이 안 되는 상황이 된다.

-- 자바는 이를 허용하지 않으며 컴파일 타임 오류를 발생시킨다.

# 힙과 스택을 통해 알 수 있는 메모리 구조 
```
B b = new A(); // 컴파일 오류!
```

🚨 이 코드가 불가능한 이유

```

[Stack]                         [Heap]
-------------------------------------------------
b (B 타입)  --->          (A 객체: A 부분만 존재)

```

B가 A를 상속 받았을 때 b가 참조하는 객체는 A이지만, B 타입은 A보다 더 많은 필드와 메소드를 가지고 있음.
즉, b.BMethod(); 같은 B의 고유 기능을 호출할 수 있어야 하는데, A 객체는 이를 제공하지 않으므로 논리적으로 불가능함.
부모 객체는 자식 객체의 기능을 포함하지 않기 때문에 이 코드가 허용되지 않음.


<hr>

**<h2>요약</h2>**
모든 상황은 "B가 A를 상속받았을 때"를 기준으로 설명한 것이고, 그에 따른 객체 생성 및 형변환의 원리를 이해하는 것이 핵심.

**👉 한 줄 요약**

**부모 타입으로 자식 객체를 참조하는 것은 가능! (A a = new B();)**
-> A 타입의 내용을 B타입은 상속을 통해서 A타입과 B타입의 필드와 메소드를 둘 다 갖고 있기 때문에 가능 

**자식 타입으로 부모 객체를 참조하는 것은 불가능! (B b = new A(); 🚫)**
-> B 타입이 A타입을 참조하게 되면, A타입의 메소드를 사용할 수 있지만 
A의 주소를 참조하고 있기 때문에 B타입이 본인의 고유 필드와 메소드를 사용할 수 없기 때문에 허용되지 않는다. 

**강제 형변환은 원본 객체가 실제로 자식 타입일 때만 가능! ( (B) a)**
