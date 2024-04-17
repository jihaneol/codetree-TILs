import java.util.*;
public class Main {
    static final int MAX_SIZE = 100_000; 
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] distance = new int[MAX_SIZE+1];
        Queue<Integer> q = new LinkedList();
        distance[a] = 1;
        q.add(a);
        while(!q.isEmpty()){
            int now = q.poll();

            if(now==b){
                System.out.print(distance[now]-1);
                return;
            }

            if(now*2 <= MAX_SIZE && distance[now*2]==0){
                q.add(now*2);
                distance[now*2] = distance[now];
            }

            if(now>0 && distance[now-1]==0){
                q.add(now-1);
                distance[now-1] = distance[now]+1;
            }

            if(now+1 <= MAX_SIZE && distance[now+1]==0){
                q.add(now+1);
                distance[now+1] = distance[now]+1;
            }
        }

    }
}