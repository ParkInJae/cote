정수 start_num과 end_num이 주어질 때, start_num에서 end_num까지의 수를 차례로 담은 
리스트를 return하도록 solution 함수를 완성 

class Solution {
    public int[] solution(int start_num, int end_num) {
        /*
        배열에 담긴 start_num부터 end_num까지 큰 순서대로 뽑기 
        > st , st-1 ,st-2, st-3, ..., end
        ->
        1.  따라서 배열의 길이가 인덱스보다 1 길다는 것을 이용 
        2. 반복문 사용해서 st -> end까지 담아야함 
        */

        
/*      1. for문 이용

        int size = start_num -end_num +1; // 배열 길이 생성
        
        int[] answer = {};
        answer = new int[size];
        
        for (int i  = 0; i < size ; i ++ ){
            answer[i] = start_num - i ;
        }
        
                
        return answer;
 
  */  
    // 2. stream 함수 사용 
    // IntStream.rangeClosed(a,b) > a부터 b 까지의 모든 정수를 포함하는 스트림 새엇ㅇ
    int answer[] = {};
    return IntStream.rangeClosed(end_num, start_num) // 내림차순 기준 
    /* Intstream.rangeClosed(start_num , end_num)  >> 오름차순 기준 */
    .map(i ->  start_num - (i - end_num)).toArray();
    /*
    rangeClosed(end_num , start_num)로 인해서 범위가 
    end_num 부터 start_ start_num까지 정해지기 때문에 
    end_num > start_num까지이기 때문에 .map을 통해서 생성되는 i가 
    end_num부터 시작한다. 
    ex end > 5 ,st 10 가정 

.map(i ->  start_num - (i - end_num)).toArray(); 으로 인해서 
    i > end_num 일때  st - (end -end)
    i > end_num + ! 일때  st - (end + 1 -end)
    i > end_num + 2 일때  st - (end + 2 -end)
    해당 결과값을 toArray를 통해서 배열로 변환시킴 

     */ 

    
    }   

    // 테스트 코드 작성
    public static void main(String[]args){
        Solution s = new Solution();
        System.out.println(s.solution);
    }


}

