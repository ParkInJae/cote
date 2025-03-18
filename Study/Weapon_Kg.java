
public class Weapon_Kg{
    public int Solution(int number, int limit, int power){  
        /*
            1. num의 약수를 구하기 
            2, num의 약수는 power
            3. power가 3을 넘기면 power는 3으로 고정 
            4. 정해진 power의 1당 weigh도 1kg씩 증가 

         */
        // 약수 구하기 
        /*빅오 사용 */

        int count = 0;
        for(int i =1;  i*i <= number; i++){
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
    
}