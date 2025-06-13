public class Find_primeNumber {
    // 소수 판별 함수: 소수이면 1, 아니면 0 반환
    // 소수 -> 약수가 자기 자신과 1
    static int isPrime(int num) {

        if( num < 2 )return 0; // 변수가 0보다 작을 때 0을 반환 

        for(int i = 2 ; i<=Math.sqrt(num); i++ ){ // 소수를 검사할 때 어차피 1은 항상 약수이기 때문에, 1을 제외하고 2부터 시작함 
        
            if ( num % i == 0){ //  약수가 존재한다. >> 소수가 아니다. ex) 9 % 3 == 0
                return 0; //  약수가 존재함 
            }
        }
     return 1;   // 반복을 전체를 돌아도 0으로 나누어지는 것 없으면 소수 판정으로 1 반환 
    }

    
    public static void main(String[] args) {
        // 검사를 해볼 최대 범위의 값 
        int num = 10;

        // 소수가 존재하면 증가 시킬 값 
        int cnt = 0;

        // 2부터 9까지 각 숫자에 대해 소수 여부를 검사
        for (int i = 2; i < num; i++) {
            
            if(isPrime(i) == 1 ){
                System.out.println(i + " 는 소수입니다.");
                cnt ++ ;
            }
        }
        System.out.println("2부터 " +num+"까지 총 소수의 개수 " +  cnt);



    
    }


    

}
