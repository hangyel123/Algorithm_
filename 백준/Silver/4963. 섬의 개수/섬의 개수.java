
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int [][] map;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int w,h;
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> queue =new ArrayDeque<>();
		int[] prev = {x,y};
		visited[x][y] = true;
		queue.addLast(prev);
		
		while(!queue.isEmpty()) {
			int[] cur= queue.pollFirst();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int d=0;d<8;d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				int[] npos = {nx,ny};
				if(nx >=0 && ny >=0 && nx < h && ny < w && map[nx][ny] == 1 && !visited[nx][ny]) {
					queue.addLast(npos);
					visited[nx][ny] = true;
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			
			for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
			
			int count=0;
			for(int i =0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visited[i][j]&&map[i][j] == 1) {
					bfs(i,j);
					count++;
				}}
			}
			System.out.println(count);
			
		}
		
		
		
	}
}
