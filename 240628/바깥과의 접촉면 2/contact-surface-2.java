import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static final int MAX_N = 300;

    public static int n, m;
    public static int[][] graph = new int[MAX_N][MAX_N];
    public static int[][] tmp = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];

    public static final int[] dx = {1, 0, -1, 0};
    public static final int[] dy = {0, 1, 0, -1};

    public static class Pair {
        public int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 집합의 개수를 체크하는 함수입니다.
    public static void check(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] != 0 && !visited[nx][ny]) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // 1턴동안 값이 줄어드는 과정을 구현하는 함수입니다.
    public static void erase() {
        // tmp 배열을 초기화합니다.
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                tmp[i][j] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) continue;

                // 맞닿아 있는 0이 적혀있는 칸 수를 저장합니다.
                int zeroCnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (graph[nx][ny] == 0) {
                        zeroCnt++;
                    }
                }
                tmp[i][j] = Math.max(graph[i][j] - zeroCnt, 0);
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                graph[i][j] = tmp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                graph[i][j] = sc.nextInt();

        int time = 0;
        // 자연수 집합 부분이 두 개 이상으로 나누어질 때 까지 반복합니다.
        while (true) {
            int cnt = 0;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    visited[i][j] = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] != 0 && !visited[i][j]) {
                        check(i, j);
                        cnt++;
                    }
                }
            }

            // 모든 자연수가 없어질 때 까지
            // 집합부분이 두 개 이상으로 나누어지지 않는다면 0을 출력합니다.
            if (cnt == 0) {
                System.out.println(0);
                break;
            }

            // 집합부분이 두 개 이상으로 나누어지면 해당 턴을 출력하고 종료합니다.
            else if (cnt >= 2) {
                System.out.println(time);
                break;
            }

            time++;
            erase();
        }
    }
}