import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        print(a*2+3);
    }
    public static <T> void print(T value){
            System.out.println(value);
    }
}