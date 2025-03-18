프로그래머스 LV! 처음 도전 <br/>
<br/>

1. Caesar_cipher.java >> 시저 함수 <br/> 
<br/>

2. countDown >> 배열에 담긴 start_num부터 end_num까지 큰 순서대로 뽑기  <br/>
ex: 10, 9, 8, 7, 6 과 같은 형태로  <br/>
<br/>

3. EffectioveDivisor >> 빅오(O√n)효과적인 약수 구하기 <br/>
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

8. for (int i = 1; i * i <= number; i++)은 시간 복잡도 {빅오 표시법의 O(√n)} 알고리즘을이용하며 특정한 정수의 약수를 구하는데 사용된다. 
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
 

