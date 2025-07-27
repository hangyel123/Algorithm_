import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static int R,C;
    static int[][] fireTime, jihunTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fireTime = new int[R][C];
        jihunTime = new int[R][C];

        ArrayDeque<int[]> jihunQueue = new ArrayDeque<>();
        ArrayDeque<int[]> fireQueue = new ArrayDeque<>();

        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = line.charAt(j);
                fireTime[i][j] = -1;
                jihunTime[i][j] = -1;

                if(map[i][j] == 'J'){
                    jihunQueue.offer(new int[]{i, j});
                    jihunTime[i][j] = 0;
                }
                else if(map[i][j] == 'F'){
                    fireQueue.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }
        while(!fireQueue.isEmpty()){
            int[] now =  fireQueue.poll();
            int x = now[0], y = now[1];

            for(int d =0;d<4;d++){
                int nx = x+dx[d], ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(fireTime[nx][ny] != -1 || map[nx][ny] == '#') continue;


                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQueue.offer(new int[]{nx,ny});
            }
        }
        while(!jihunQueue.isEmpty()){
            int[] now = jihunQueue.poll();
            int x = now[0], y= now[1];

            if(x == 0 || y == 0 || x == R-1 || y == C-1 ){
                System.out.println(jihunTime[x][y] + 1);
                return;
            }

            for(int d= 0;d<4;d++){
                int nx = x+dx[d], ny = y+dy[d];

                if(nx <0 || ny <0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] == '#' || jihunTime[nx][ny] != -1) continue;
                if(fireTime[nx][ny] != -1 && fireTime[nx][ny] <=  jihunTime[x][y] + 1) continue;

                jihunTime[nx][ny] = jihunTime[x][y] + 1;
                jihunQueue.offer(new int[]{nx,ny});
            }
        }
        System.out.println("IMPOSSIBLE");


    }
}
