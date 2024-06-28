import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static final int MAX_N = 505;
    public static final int MAX_C = 250005;

    public static int n, m;
    public static int[][] graph = new int[MAX_N][MAX_N];

    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static int answer = 0;
    public static int group = 1;

    public static int[][] visited = new int[MAX_N][MAX_N];
    public static int[] group_size = new int[MAX_C];

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Queue<Point> q = new LinkedList<>();

    // 1인 칸들을 그룹화하는 함수입니다.
    public static void BFS(int x, int y) {
        // 각 그룹별 몇 칸이 연결되어 있는지를 저장합니다.
        group_size[group]++;
        visited[x][y] = group;

        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;

            // BFS로 연속된 1의 칸 수를 구해줍니다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 새 좌표가 유효하고 방문한적 없는 1인 칸인 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && visited[nx][ny] == 0) {
                    // 각 그룹별 몇 칸이 연결되어 있는지를 저장합니다.
                    group_size[group]++;
                    visited[nx][ny] = group;

                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<int[]> vt = new ArrayList<>();

        // 그래프를 입력받고 0의 좌표를 저장합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();

                if (graph[i][j] == 0)
                    vt.add(new int[]{i, j});
            }
        }
        
        // 만약 0인 좌표가 없다면, 무조건 하나를 변경해야 하므로 
        // n * m - 1 이 답이 됩니다.
        if (vt.size() == 0) {
            System.out.println(n * m - 1);
            return;
        }

        // 1인 칸들을 그룹화합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    group++;
                    BFS(i, j);
                }
            }
        }

        // 0인 좌표들을 탐색합니다.
        for (int i = 0; i < vt.size(); i++) {
            int x = vt.get(i)[0];
            int y = vt.get(i)[1];
            int cnt = 1;
            HashMap<Integer, Integer> plus = new HashMap<>();

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1) {
                    plus.put(visited[nx][ny], group_size[visited[nx][ny]]);
                }
            }

            // 주변 그룹의 개수를 더합니다.
            for (int value : plus.values()) {
                cnt += value;
            }
            answer = Math.max(answer, cnt);
        }

        // 결과를 출력합니다.
        System.out.println(answer);
    }
}