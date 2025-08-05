import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 촌수 계산할 사람 A
        int b = Integer.parseInt(st.nextToken()); // 촌수 계산할 사람 B

        int m = Integer.parseInt(br.readLine().trim());

        // 인접 리스트 (1..n)
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child  = Integer.parseInt(st.nextToken());
            // 부모-자식 관계를 양방향으로 추가
            adj[parent].add(child);
            adj[child].add(parent);
        }

        // BFS
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist[a] = 0;
        q.offer(a);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == b) break; // 목적지 도달하면 종료 가능
            for (int nx : adj[cur]) {
                if (dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    q.offer(nx);
                }
            }
        }

        System.out.println(dist[b]); // 연결되어 있지 않으면 -1 출력됨
    }
}
