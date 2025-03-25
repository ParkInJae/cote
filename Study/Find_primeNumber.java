public class Find_primeNumber {

     
    
    // 소수 판별 함수: 소수이면 1, 아니면 0 반환
    public static int s(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
        int num = 10;
        int cnt = 0;
        // 2부터 9까지 각 숫자에 대해 소수 여부를 검사
        for (int i = 2; i < num; i++) {
            cnt += s(i);
            System.out.println(cnt);
        }
    }
}
