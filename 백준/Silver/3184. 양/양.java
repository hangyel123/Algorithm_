import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		int sheep = 0;
		int wolf = 0;
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		for(int i = 0; i<R;i++) {
			for(int j=0;j<C ;j++) {
				if(map[i][j] == 'o') sheep+=1;
				if(map[i][j] == 'v') wolf+=1;
			}
		}
		
		System.out.println(sheep+" "+wolf);
	}

	static void bfs(int r, int c) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		Stack<int[]> sheepPos = new Stack<>();
		Stack<int[]> wolfPos = new Stack<>();
		queue.addLast(new int[] { r, c });

		int sheep = 0;
		int wolf = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			int curX = cur[0];
			int curY = cur[1];
			
			
			
			if (map[curX][curY] == 'o') {
				sheep += 1;
				sheepPos.push(new int[] {curX, curY});
			}

			if (map[curX][curY] == 'v') {
				wolf += 1;
				wolfPos.push(new int[] {curX, curY});
			}
			for (int d = 0; d < 4; d++) {
				int nx = dx[d] + curX;
				int ny = dy[d] + curY;

				if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny] != '#') {
					visited[nx][ny] = true;
					queue.addLast(new int[] { nx, ny });
				}
			}
		}
		if(sheep > wolf) {
			while(!wolfPos.isEmpty()) {
				int[] pos = wolfPos.pop();
				map[pos[0]][pos[1]] = '.';
			}
		}
		else {
			while(!sheepPos.isEmpty()) {
				int[] pos = sheepPos.pop();
				map[pos[0]][pos[1]] = '.';
			}
		}
	}

}
