

import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static boolean[] isdVisited;
	static boolean[] isbVisited;
	 static StringBuilder sb = new StringBuilder();	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		isdVisited = new boolean[N+1];
		isbVisited = new boolean[N+1];
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(V);
		System.out.println(sb);
		 sb.setLength(0);
		bfs(V);
		System.out.println(sb);
	}
	
	static void dfs(int pos) {
		isdVisited[pos] = true;
		sb.append(pos).append(' ');
		
		for(int i=1;i<graph.length;i++) {
			if(graph[pos][i] == 1 && !isdVisited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		isbVisited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()){
			int cur = queue.poll();
			sb.append(cur).append(" ");
			
			for(int i = 1;i<graph.length;i++) {
				if(graph[cur][i] == 1 && !isbVisited[i]) {
					isbVisited[i] = true;
					queue.offer(i);
				}
			}
			
		}
		
	}
	
	
}