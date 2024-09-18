import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int  c= sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        print(a>b?1:0);
        print(a>c?1:0);
        print(a>d?1:0);
        print(a>e?1:0);
      
      
        
    }
   
    public static <T> void print(T value){
            System.out.println(value);
    }

     public static <T> void printf(T value){
            System.out.printf("%.2f",value);
    }
}