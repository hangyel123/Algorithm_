

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] rect;
	static boolean[][] visited;
	static int M, N, area;
	static ArrayList<Integer> list;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1}; 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		rect = new int[M][N];
		visited = new boolean[M][N];
		list = new ArrayList<Integer>();
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int x = x1; x < x2; x++) {
				for(int y = y1;y<y2;y++) {
					rect[M - 1 - y][x]=1;
				}
			}
		}
		int ground = 0;
		for(int i=0;i<M;i++) {
			for(int j=0; j<N;j++) {
				if(rect[i][j]== 0 && !visited[i][j]) {
					area = 0;
					dfs(i,j);
					list.add(area);
					ground++;
				}
			}
		}
		
		list.sort(null);
		System.out.println(ground);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	
	static void dfs(int x, int y) {
		visited[x][y] =true;
		area++;
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx >= 0 && ny >=0 && nx < M && ny <N && rect[nx][ny] == 0 && !visited[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}
}
