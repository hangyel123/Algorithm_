import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int r,c;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		paper = new int [r][c];
		visited = new boolean [r][c];
		
		
		
		for(int i=0;i<r;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				paper[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		int draw = 0;
		int max = 0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(paper[i][j] == 1 && !visited[i][j]) {
					draw++;
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		System.out.println(draw);
		System.out.println(max);
	}
	
	static int bfs(int x, int y){
		int area = 1;
		ArrayDeque<int []> queue = new ArrayDeque<>();
		queue.addLast(new int[] {x,y});
		 visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			int curx = cur[0];
			int cury = cur[1];
			
			for(int d=0;d<4;d++) {
				int nx = curx+dx[d];
				int ny = cury+dy[d];
				
				if(nx >=0 && ny>=0 && nx<r && ny <c && !visited[nx][ny] && paper[nx][ny] == 1) {
					queue.addLast(new int[] {nx,ny});
					visited[nx][ny] = true;
					area++;
				}
			}
			
		}
		return area;
			
	}
	
}
