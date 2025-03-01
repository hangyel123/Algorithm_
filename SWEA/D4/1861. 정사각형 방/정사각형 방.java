import java.io.*;
import java.util.*;

public class Solution{
    static int N;
    static int[][] rooms;
    static int startroom;
    static int change;

    static int[] dx = {-1,1,0,0};    //상 하 좌 우
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test = 1;test<= T; test++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];

            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            startroom = 0;
            change  = 0;
            for(int i = 0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    int cnt = dfs(i,j,1);
                    if(cnt > change || (cnt == change && startroom > rooms[i][j])) {
                    	startroom = rooms[i][j];
                    	change = cnt;
                    }
                }
            
            }
            System.out.println("#" + test+" "+startroom+" "+change);

        }
    }

    public static int dfs(int x,int y,int count) {
    	int maxLength = count;
    	
    	for(int d = 0;d<4;d++) {
    		int nx = x+dx[d];
    		int ny = y+dy[d];
    		if(nx>=0 && ny>=0 && nx < N && ny < N && rooms[nx][ny] == rooms[x][y] +1) {
            	maxLength = Math.max(maxLength,dfs(nx,ny,count+1));
            }
    		
    	}
    	
    		return maxLength;

    }
}