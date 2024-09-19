import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int x = sc.nextInt();
            if(x%3==0 && x%2!=0){
                System.out.println(x);
            }
        }
    }
}