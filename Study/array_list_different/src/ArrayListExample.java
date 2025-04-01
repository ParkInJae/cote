import java.util.ArrayList;

public class ArrayListExample{

    
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        // 값 추가
        arr.add("Hello");  // arr은 100 번지라고 가정
        arr.add("World");

        ArrayList<String> arr2 = arr; // ArrayList<String> arr2는 arr의 주소를 참조 
        arr2.remove(0); // 100 번지의 0번 인덱스 삭제 
        
        arr.add("Vinatect"); 
        // 변수명은 다르지만 arr2와 arr이 참조하는 값이 같으므로
        // 동일한 객체에 문자열을 추가함 
        ArrayList<String> arr3 = new ArrayList<>(); // new 연산자로 인해서 100 번지가 아닌 새로운 주소를 참조하는 arr3 리스트 생성
        arr3.add("하.. 문제 틀린거 너무 아쉽다...");
        arr.add("null");
        arr.add("하...");

        System.out.println(arr); // [World , Vinatect]이 출력됨
        System.out.println("-------------------");
        System.out.println(arr2); // [World , Vinatect]이 출력됨
        System.out.println(arr3); // [하.. 문제 틀린거 너무 아쉽다..., null, 하...] 출력됨
        
    }
}