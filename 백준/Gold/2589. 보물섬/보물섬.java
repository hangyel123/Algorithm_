
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int w,h,maxDist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void bfs(int startX,int startY) {
    	boolean[][] visited = new boolean[w][h];
    	int[][] dist = new int[w][h];
    	ArrayDeque<int[]> queue = new ArrayDeque<>();
        
    	queue.addLast(new int[] {startX,startY});
        visited[startX][startY]= true;
        dist[startX][startY]= 0;


        while(!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int curX = cur[0];
            int curY = cur[1];
        

            for(int d=0;d<4;d++) {
                int nx = curX+dx[d];
                int ny = curY+dy[d];

                if(nx>=0 && ny >=0 && nx<w && ny<h && map[nx][ny] == 'L' && !visited[nx][ny]) {
                	visited[nx][ny] = true;
                	dist[nx][ny] = dist[curX][curY] +1;
                    maxDist = Math.max(maxDist, dist[nx][ny]);
                	queue.addLast(new int[] {nx,ny});  
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        maxDist = 0;

        map = new char[w][h];


        for(int i=0;i<w;i++) {
            map[i] = br.readLine().toCharArray();
        }


        for(int i=0;i<w;i++) {
            for(int j=0;j<h;j++) {
                if(map[i][j]=='L') {
                    bfs(i,j);
                }
            }
        }
        System.out.println(maxDist);

    
}
}