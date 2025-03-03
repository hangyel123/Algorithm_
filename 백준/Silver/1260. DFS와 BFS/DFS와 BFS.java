
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static int[][] gragh = new int[1001][1001];
	static int N,M,V;
	static ArrayDeque<Integer> queue = new ArrayDeque<>();
	
	static void dfs(int idx) {
		
		visited[idx] = true;
		System.out.print(idx+" ");
		for(int i=1;i<=N;i++) {
			if(!visited[i] && gragh[idx][i] == 1) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int idx) {
		visited[idx] = true;
		
		queue.addLast(idx);
	
		while(!queue.isEmpty()) {
			int bfsidx = queue.pollFirst();
			System.out.print(bfsidx+" ");
			for(int i=1;i<=N;i++) {
				if(!visited[i] && gragh[bfsidx][i] == 1) {
					queue.addLast(i);
					visited[i] = true;
					
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			gragh[start][end] = gragh[end][start] = 1;
		}
		visited = new boolean[1001];
		dfs(V);
		System.out.println();
		visited = new boolean[1001];
		bfs(V);
		
	}
}
