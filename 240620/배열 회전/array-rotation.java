import java.util.*;
public class Main {
    private static int[][] map;
    private static int N,M,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        
        for(int i=0; i<N ;i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();    
            }
        }

        while(K-->0) rotate();
            
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void rotate(){
         int r = 0;
            int c = 0;

            int maxLen = Math.min(M,N)/2;
            int maxRow = N;
            int maxCol = M;
            int minRow = 0;
            int minCol = 0;
            while(maxLen-->0){
                int temp = map[r][c];
                while(c<maxCol-1){
                    c++;
                    map[r][c-1] = map[r][c];
                }
            
                while(r<maxRow-1){
                    r++;
                    map[r-1][c] = map[r][c];
                }
                
                while(c>minCol){
                    c--;
                    map[r][c+1] = map[r][c];
                }

                while(r>minRow){
                    r--;
                    map[r+1][c] = map[r][c];
                }
                
                map[r+1][c] = temp;
                r++;
                c++;
                maxRow--;
                maxCol--;
                minRow++;
                minCol++;
            }   
    }
}