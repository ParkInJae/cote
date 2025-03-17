public class Number_of_divisors_and_addition{


    // 약수의 개수와 덧셈 

    public int solution(int left, int right) {
     
        int count = 0; 
        for(int i = left; i <= right; left ++ ){
            
            for(int j =1; j*j <=i; j++){
                if(i % j == 0 ){
                    count++;

                    if (j !=i/j){
                        count++;
                    }
                    if(count % 2 == 0){
                        i +=i;
                    }else if (count % 2 == 1){
                        i -= i ;
                    }
                }
            }

        }
            return count;
    }
/*
    1.  해당 코드의 문제점 약수의 개수(count)변수의 재사용 및 초기화
    모든 숫자에 대해 약수의 개수를 새로 세야하는데 매 숫자마다 count를
    0으로 초기화하지 않아서 계속해서 누적이된다. 
    => 따라서 반복문 시작시 count를 0으로 초기화해야한다. 

    2. 약수 개수를 구하는 로직 오류 
    약수의 개수를 구할 때 전체 약수를 구하지 않고 약수를 구하자마자 
    count의 짝수, 홀수를 검사한다. 
    3. 문제의 의도는 최종 결과값에 해당 수를 더하거나 빼는 것이지 
    값을 직접 수정하는 것이 아니므로  
                    if (j !=i/j){
                        count++;
                    }
                    if(count % 2 == 0){
                        i +=i;
                    }else if (count % 2 == 1){
                        i -= i ;
                    }
                        로직은 잘못되었다. 

    4. 최종적으로 반환해야 하는 값 오류
    코드 마지막에 return count;로 반환하는데, 이는 약수의 개수를 누적한 값
    문제에서 요구하는 것은 각 숫자의 약수 개수에 따라 더하거나 뺀 최종 누적 합
    => 올바른 최종 결과를 저장할 변수(answer)를 선언하고, 이를 반환해야 함.
*/

    public int EditedSolution(int left, int right) {
        int answer = 0;
        
        // left부터 right까지 각 숫자에 대해 처리
        for (int i = left; i <= right; i++) { // left부터 right까지 반복 
            int divisorCount = 0; // 약수 개수 
            
            // 약수의 개수를 효율적으로 구하기 위해 √i 까지만 반복
            for (int j = 1; j * j <= i; j++) { // i는 left -> right까지 반복하는 것 
                if (i % j == 0) {  // 제곱근 
                    // j가 약수이면, i/j도 약수
                    divisorCount++;
                    if (j != i / j) {
                        divisorCount++;
                    }
                }
            }
            
            // 반복이 끝난 후 
            // 약수의 개수가 짝수이면 더하고, 홀수이면 뺌
            if (divisorCount % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }




    /* 
    api를 활용한 다른 풀이 Math.sqrt() 
    >> 약수의 개수가 짝수일 때 제곱근 x , 약수의 개수가 홀수일 때 제곱근 o
    따라서  
    1. 전체 반복 롤림
    2. 전체 반복 속에서 제곱근 존재하면 answer이라는 숫자를 담는 변수에 돌아가고 있는 
    변수를 더하거나 뺄 수 있음  
     
    */
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) { // Msth.sqrt()는 숫자의 제곱근을 반환한다.
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
}

}
