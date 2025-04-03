public class static_example {


    static int count = 1;  // static 선언 

    public void method(){
        count++;
        System.out.print(count + " ");
    }




    public static void main(String[] args) throws Exception {
     
        static_example st = new static_example();
        st.method();
        st.method();
        st.method();

        
    }
}
