import java.util.Arrays;

public class ArrayExample {
    
    public static void main(String []args){
        int[] array = {1,2,3,4};
        System.out.println("배열을 출력시 , 해시코드와 타입으로 이루어진 값이 나옴  ");
        System.out.println("값 :: "+ array);


        // 배열의 원소를 출력하기 위해서는 Arrays.toString()을 사용해야함 
        // Arrays.toString() 메소드는 자동으로 쉼표와 공백이 포함된 형태로 출력이 된다. 
        System.out.println("배열의 내부 원소" + Arrays.toString(array));

    }
}
/*
 배열을 출력하면, 해시코드와 타입으로 이루어진 형태의 값이 출력된다. 
 배열의 원소를 출력하기 위한 방법은 2가지가 있다. 
 1. Arrays.toString(선언한 배열명)을 사용하는 방법 
    해당 메소드를 사용하게 된다면 []에 감싸지고, 쉼표와 공백이 포함된 형태로 나온다. 
    int [] a = {1,2,3,4} 
    Arrays.toString(a);
 -> [1, 2, 3, 4]

 2. 반복문을 사용해서 내부 요소를 하나씩 수정하는 방법 
for문이나 향상된 for문을 사용하는 것이다. 
(해당 반복문은 띄어쓰기가 자동 적용이 되지 않고, []에 감싸져 나오지 않음)

System.out.println("배열의 내부 원소");

for(int i = 0; i < a.length; i++){
    System.out.print("a[i]");
}
-> 1234

 */