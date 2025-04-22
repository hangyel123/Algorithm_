import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> home = new ArrayList<>();
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					home.add(new int[] {i,j});
				}
				else if(map[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		
		selected = new int[M];
		comb(0,0);
		System.out.println(min);

	}
	
	static void comb(int depth, int start) {
		if(depth == M) {
			int sum = 0;
			
			for(int h[] : home) {
				int dist = Integer.MAX_VALUE;
				for(int i=0;i<M;i++) {
					int[] c = chicken.get(selected[i]);
					int d = Math.abs(c[0]- h[0]) + Math.abs(c[1]-h[1]);
					dist = Math.min(dist, d);
				
				}
				sum += dist;
			}
			
			min = Math.min(sum, min);
			return;
		}
		
		for(int i = start; i<chicken.size();i++) {
			selected[depth] = i;
			comb(depth+1, i+1);
		}
		
	}
}
