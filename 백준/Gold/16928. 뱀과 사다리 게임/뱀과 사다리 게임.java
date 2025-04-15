import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] board;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		board = new int[101];

		for (int i = 0; i < 101; i++) {
			board[i] = i;
		}

		// 사다리
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			board[s] = e;
		}
		// 뱀
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			board[s] = e;

			
		}
	
		System.out.println(bfs());

	}

	
	static int bfs() {
		boolean[] visited = new boolean[101];
		ArrayDeque<int[]>queue = new ArrayDeque<>();
		visited[1] = true;
		queue.addLast(new int[] {1, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			int pos = cur[0];
			int cnt = cur[1];
			
			if(pos == 100) return cnt;
			
			for(int i = 1; i<= 6 ;i++) {
				int next = pos +i;
				if(next > 100) continue;
				
				next = board[next];
				if(!visited[next]) {
					queue.addLast(new int[] {next, cnt+1});
					visited[next] = true;
				}
				
			}
		}
		return -1;
	}
}