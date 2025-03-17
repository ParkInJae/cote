public class EffectioveDivisor{


    /*
        1. 전체를 도는 코드 (Naive, O(n) 방식)
    */
    public int countDivisorsNaive(int n) {
        int count = 0;
        // i가 1부터 n까지 모든 수를 확인합니다.
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
    /* 
        설명 :: 
        for 문 ::  (선언; 종료; 증감 조건):
        1. 초기화: int i = 1
        2. 종료 조건: i <= n → n까지 모든 수에 대해 검사
        3. 증감: i++ → 매 반복마다 1씩 증가
        시간 복잡도: O(n)
        n이 커지면 반복 횟수가 선형적으로 증가하여 비효율적입니다.

    */

    /*
        ** 효율적인 코드 (O(√n) 방식)

        방법 1
        */
        public int countDivisorsOptimized1(int n) {
            int count = 0;
        // i * i <= n 조건을 통해 i가 √n 이하일 때까지만 반복합니다.
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;  // 작은 약수 i를 카운트
                if (i != n / i) {
                    count++;  // 대응하는 큰 약수 n/i도 카운트 (단, 중복 방지)
                }
            }
        }
        return count;
    }
    /*
    방법 2
     */
    public int countDivisorsOptimized2(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                count++;  // 제곱근인 경우 (중복 방지)
            } else if (n % i == 0) {
                count += 2;  // i와 n/i 두 개의 약수를 동시에 카운트
            }
        }
        return count;
    }
    /*
     for문 선언 및 종료 조건
      초기화 int i =1;
      종료 조건 :: i * i <= n 

      여기서 O(√n) 이 적용된다고 볼 수 있다. 
      이 조건은 i 가 √n 이하일 때만 반복되도록 한다. 

      즉, 시간 복잡도 O(√n)가 n의 제좁근까지만 반복하여 n이 커져도 반복 횟수가 훨씬
      적어진다는 것을 알 수 있다. 

      에시 :: n이 36인 경우 그 제곱근인 6까지만 반복하게 되어 
      기존의 for 문이 36번을 돌 동안 6번만 돌면 해결된다. 

      핵심: 약수는 항상 두 개의 쌍(예, (i, n/i))으로 존재하기 때문에, 
      작은 약수 i를 찾으면 큰 약수 n/i도 알 수 있다. 
      이 성질을 이용해 반복 횟수를 줄입니다.
    */
    

}