import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        if(a>1){
             for(int i=0; i<n; i++){
            print(a);
        }
        }else{
            print(0);
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

    public static <T> void println(T value){
            System.out.println(value);
    }

     public static <T> void printf(T value){
            System.out.printf("%.2f",value);
    }
}