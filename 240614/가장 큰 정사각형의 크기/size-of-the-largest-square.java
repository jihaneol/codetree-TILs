import java.util.Scanner;

public class Main {
    public static final int MAX_N = 501;

    public static int n, m;
    public static int[][] arr = new int[MAX_N][MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 행과 열 크기를 입력받습니다.
        n = sc.nextInt();
        m = sc.nextInt();

        // 배열의 각 원소를 입력받습니다.
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0; // 정답을 저장할 변수를 초기화합니다.

        // 각 배열의 원소에 대하여 연산을 수행합니다.
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                // 현재 원소가 0이 아닌 경우에 대하여 연산을 수행합니다.
                if(arr[i][j] != 0) {
                    // 현재 위치의 왼쪽, 위, 왼쪽 위 대각선의 dp값 중 가장 작은 값에 1을 더한 값을 현재 위치에 저장합니다.
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                    // 최댓값을 갱신합니다.
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }

        // 정답의 제곱을 출력합니다.
        System.out.println(ans * ans);
    }
}