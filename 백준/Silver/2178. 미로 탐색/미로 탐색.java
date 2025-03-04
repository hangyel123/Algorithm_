
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] maze;
	static int M,N;
	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,-1,1};//상하좌우
	
	
	static int bfs(int x,int y) {
		//기저조건 다음이 N,M이면 끝
		ArrayDeque<int[]>queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.addLast(new int[] {x,y,1});
		while(!queue.isEmpty()) {
			int[] current = queue.pollFirst();
			int cx = current[0];
			int cy = current[1];
			int distance = current[2];
			
			if(cx == N-1 && cy == M-1) {
				return distance;
			}
			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];
				if(nx >=0 && ny>=0 && nx<N && ny<M && maze[nx][ny]== 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.addLast(new int[] {nx,ny,distance+1});
				}	
			}	
		}		
	return -1;	
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		maze = new int[N][M]; 
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				maze[i][j] = line.charAt(j)-'0';
			}
		}
		
		int ans = bfs(0,0);
		System.out.println(ans);
		
	}
}
