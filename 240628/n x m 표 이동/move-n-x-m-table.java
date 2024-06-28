import java.util.*;
public class Main {
    private static int N,M;
    private static final int MOD = 1_000_000_007;
    private static int[][] map, dp;
    private static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dp = new int[N][M];
        map = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.print(descend(0,0));

    }

    public static int descend(int x, int y){

        if(x==N-1 && y==M-1) return 1;

        if(dp[x][y]==-1){
            dp[x][y] = 0;

            for(int i=0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(!isRange(nx,ny) || map[x][y] <= map[nx][ny]) continue;

                dp[x][y]+=descend(nx,ny);
                dp[x][y]%=MOD;
            }

        }

        return dp[x][y];

    }
    public static boolean isRange(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }
}