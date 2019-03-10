package app;

public class HeapPQDriver{

    public static void main(String[] args){

        HeapPQ<Integer,String> test = new HeapPQ<Integer,String>();
        test.insert(10, "Gyou");
        test.insert(5, "Gyou");
        test.insert(5, "Gyouuuuu");
        test.insert(2, "Gyou");
        test.insert(9, "Gyou");
        test.insert(2, "Gyoooou");
        test.insert(1, "Gyou");
        System.out.println(test.toString());
        test.remove(); 
        System.out.println(test.toString());
        test.remove();
        test.remove();                      
        System.out.println(test.toString());

    }
}