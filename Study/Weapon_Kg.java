
public class Weapon_Kg{
    public int solution(int number, int limit, int power){  
        /*
            0. 전체 반복을 실행 
            1. num의 약수를 구하기 
            2, num의 약수는 power
            3. power가 3을 넘기면 power는 3으로 고정 
            4. 정해진 power의 1당 weigh도 1kg씩 증가 

         */
        // 약수 구하기 
        /*빅오 사용 */

        int count = 0;
        for(int i =1;  i*i <= number; i++){  // -> 이 부분은 하나의 정수의 약수를 효율적으로 구하기 위한 알고리즘
            // 즉 전체를 순히하는 것이 아닌 단 하나의 정수에 대한 약수를 계산함
            count = 0;
            if(number % i == 0){  // 제곱근 구할 때 
                count++;
            }else if(i != number / i){
                count++;
            }
        }

        // power에 해당하는 무게 구하기 
        if (count <= limit){
            power += count;
        }else {
            power += 2;
        }
        int answer =power;

        return answer;
    }
 
    /*
    수정된 코드 
    https://chatgpt.com/c/67d7fa60-716c-8005-8f12-813364200c22
`   class Solution {
    public int solution(int number, int limit, int power) {
        int totalWeight = 0;
        
        for (int n = 1; n <= number; n++) {
            int count = 0;
            int sqrt = (int)Math.sqrt(n); //O(√n) 를 이용하기 때문에 sqrt를 이용해서 제곱근을 얻어옴
            for (int i = 1; i <= sqrt; i++) {  
                if (n % i == 0) {
                    // 약수가 하나라면 (제곱수인 경우)
                    if(i * i == n)
                        count++;
                    else
                        count += 2;
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


    */

}