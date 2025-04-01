import java.util.ArrayList;

public class array_list_different{

    
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        
        // 값 추가
        arr.add("Hello");
        arr.add("World");
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.remove(1);
        
        System.out.println(arr);
        System.out.println(arr2);
        
    }
}