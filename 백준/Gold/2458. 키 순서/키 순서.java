import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static ArrayList<Integer>[] higher, lower;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		higher = new ArrayList[N + 1];
		lower = new ArrayList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			higher[i] = new ArrayList<>();
			lower[i] = new ArrayList<>();
		}

	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			higher[a].add(b);
			lower[b].add(a);
		}
		cnt = 0;

		for (int i = 1; i <= N; i++) {
			int taller = bfs(i, higher);
			int shorter = bfs(i, lower);
			
			if(taller + shorter == N-1) cnt++;
		}
		
		System.out.println(cnt);
	}

	static int bfs(int idx, List<Integer>[] gragh) {
		boolean[] visited = new boolean[N + 1];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		visited[idx] = true;
		queue.add(idx);
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next : gragh[cur]) {
				if(!visited[next]) {
					visited[next]=true;
					queue.add(next);
					cnt+=1;
				}
			}
		}
		return cnt;
	}
	
	
}
