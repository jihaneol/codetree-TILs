import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] a = sc.next().split("-");
        print(a[0]+"-"+a[2]+"-"+a[1]);
    }
    public static <T> void print(T value){
            System.out.println(value);
    }
}