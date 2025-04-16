import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int[][] cheese;
	static boolean[][] visited;
	static int row, col;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		cheese = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int lastCount = 0;

		while (true) {
			visited = new boolean[row][col];
			int currentCheese = count();
			if (currentCheese == 0)
				break;

			lastCount = currentCheese;
			bfs(0, 0);
			time++;
		}

		System.out.println(time);
		System.out.println(lastCount);
	}

	static int count() {
		int cnt = 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (cheese[i][j] == 1)
					cnt++;
		return cnt;
	}

	static void bfs(int x, int y) {
		visited[x][y] = true;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y });
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int d = 0;d<4;d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(cheese[nx][ny] == 1) {
						cheese[nx][ny] = 0;
					}
					else if(cheese[nx][ny] == 0) {
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		
	}
}
