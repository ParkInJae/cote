
/*
시저 암호
문제 설명
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

제한 조건
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.

입출력 예
s	n	result
"AB"	1	"BC"
"z"	1	"a"
"a B z"	4	"e F d"
 */
    //기존 코드 
/* 
public class Caesar_cipher{
    
    
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            return answer;
        }
    }
}
*/
    // 작성한 코드 
    class Caesar_cipher { // 시저 암호 
        String caesar(String s, int n) {
            String result = ""; // 반환할 문자열 생성 
        n = n % 26; // 알파벳의 개수 26개 
        for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i); // String의 각각의 인덱스를 문자로 변환 
          if (Character.isLowerCase(ch)) {
            ch = (char) ((ch - 'a' + n) % 26 + 'a'); //  문자형 + 정수형 = 정수형
            // (i번째 인덱스 - 문자열 a + 밀어야하는 숫자) 
             // %26(26을 초과하면 알파벳이 아닐 수 있으니까) + '소문자 알파벳 시작 a '
          } else if (Character.isUpperCase(ch)) {
            ch = (char) ((ch - 'A' + n) % 26 + 'A');
          }
          result += ch;
        }
            return result;
        }

        // 테스트 코드 작성 
        public static void main(String[] args) {
            Caesar_cipher c = new Caesar_cipher();
            System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
        }
    }
