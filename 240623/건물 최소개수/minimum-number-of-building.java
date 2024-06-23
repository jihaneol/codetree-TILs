import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int building = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            while(!stack.isEmpty() && stack.peek()>y){
                if(stack.peek()!=0) building++;
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek()==y) continue;

            stack.push(y);
        }
         while(!stack.isEmpty()){
            if(stack.peek()!=0) building++;
            stack.pop();
        }
        System.out.print(building);
    }
}