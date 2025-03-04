import java.io.*;
import java.util.*;

public class Main {
	static boolean [][] visited;
	static int [][] farm;
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	static int M;
	static int N;
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx>=0 && ny >= 0 && nx<M && ny<N && farm[nx][ny]==1 && !visited[nx][ny]) {
				dfs(nx,ny);
			}
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test =1; test<=T;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken());
			farm = new int[M][N];	
			visited = new boolean[M][N];	
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				farm[x][y] = 1;
			}
			int count = 0;
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(farm[i][j] == 1 && !visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
			
		}
			System.out.println(count);	
	}}
}
