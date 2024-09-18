import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        int b = sc.nextInt();
        printf((a+b)/(a-b));
    }
    public static <T> void print(T value){
            System.out.println(value);
    }

     public static <T> void printf(T value){
            System.out.printf("%.2f",value);
    }
}