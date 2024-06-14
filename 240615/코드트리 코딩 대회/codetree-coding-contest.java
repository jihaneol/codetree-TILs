import java.util.*;

public class Main {
    static int N, M, answer = 13;
    static Set<Map<Map.Entry<Integer, Integer>, Integer>> dp = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[] infos = new int[N];
        for (int i = 0; i < N; i++) {
            infos[i] = sc.nextInt();
        }

        // 최대 집중력보다 크면 x
        if (Arrays.stream(infos).max().getAsInt() > M) {
            System.out.println(-1);
        } else {
            // 누가 푸는지는 상관 x
            // 상태를 결정짓는 요소는 {집중1:남은, 집중력2:인원} 형태
            Map<Integer, Integer> focus = new HashMap<>();
            focus.put(M, N);
            dfs(focus, infos, new ArrayList<>());
            System.out.println(answer);
        }
    }

    static void dfs(Map<Integer, Integer> focus, int[] infos, List<Integer> used) {
        if (dp.contains(focus)) {
            return;
        }
        dp.add(new HashMap(focus));

        // 다 풀었으면 최소 인원 갱신
        if (used.size() == infos.length) {
            answer = Math.min(answer, N - focus.getOrDefault(M, 0));
            return;
        }

        // 백트래킹 형태로
        int x = infos[used.size()];
        used.add(x);
        List<Integer> keys = new ArrayList<>(focus.keySet());
        for (int f : keys) {
            if (focus.get(f) != null && focus.get(f) > 0 && f >= x) {
                focus.put(f - x, focus.getOrDefault(f - x, 0) + 1);
                focus.put(f, focus.get(f) - 1);
                if (!dp.contains(focus)) {
                    dfs(focus, infos, used);
                }
                focus.put(f - x, focus.get(f - x) - 1);
                focus.put(f, focus.get(f) + 1);
            }
        }
        used.remove(used.size() - 1);
    }
}