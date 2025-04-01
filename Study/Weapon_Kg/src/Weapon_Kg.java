
public class Weapon_Kg{
    
    //   링크 : https://school.programmers.co.kr/learn/courses/30/lessons/136798
    public int solution(int number, int limit, int power) {
  
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
      }
  }