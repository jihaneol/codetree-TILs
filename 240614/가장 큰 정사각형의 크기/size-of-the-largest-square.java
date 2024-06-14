import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map;
    public static int M,N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSquareSize = Math.min(N, M);
        int largestArea = 0;

        for (int size = maxSquareSize; size >= 1; size--) {
            if (canFindSquare(size)) {
                largestArea = size * size;
                break;
            }
        }

        System.out.println(largestArea);
    }

    private static boolean canFindSquare(int size) {
        for (int i = 0; i <= N - size; i++) {
            for (int j = 0; j <= M - size; j++) {
                if (isSquare(i, j, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSquare(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}