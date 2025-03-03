
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] graph;
	static int cnt=0;
	static boolean[] visited;
	
	public static void dfs(int idx) {
		visited[idx] = true;
		for(int i=1;i<=N;i++) {
			if(!visited[i] && graph[idx][i] == 1) {
				cnt= cnt+1;
				dfs(i);
			}
		}
		
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		graph =new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = graph[end][start] = 1;	
			}
		dfs(1);
		System.out.println(cnt);
	}
	
	
}
