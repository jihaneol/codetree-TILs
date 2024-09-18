import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i=a; i<=b; i++){
            if(i%2!=0)
            print(i+ " ");
        }
        // int[] arr = new int[3];
        // for(int i=0; i<3; i++){
        //     arr[i] = sc.nextInt();
        // }
        // for(int i=0; i<2; i++){
        //     for(int j=i; j<2; j++){
        //         if(arr[j]>arr[j+1]){
        //             int temp = arr[j];
        //             arr[j] = arr[j+1];
        //             arr[j+1] = temp;
        //         }
        //     }
        // }
        // print(arr[1]);
      
        
    }
    public static <T> void print(T value){
            System.out.print(value);
    }

     public static <T> void printf(T value){
            System.out.printf("%.2f",value);
    }
}