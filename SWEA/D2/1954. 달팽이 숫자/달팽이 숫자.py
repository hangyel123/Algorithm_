import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine().trim());
    	
    	for(int tc = 1; tc <= T; tc++) {
    		int n =Integer.parseInt(br.readLine().trim());
    		
    		int[][] num = new int[n][n];
    		int[] dx = {0,1,0,-1};
    		int[] dy = {1,0,-1,0};
    		
    		
    		int x = 0,y=0,cnt=1, idx= 0;
    		
    		while(cnt <= n*n) {
    			num[x][y]=cnt++;
    			
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			if(nx < 0 || ny <0 || nx>=n || ny>= n || num[nx][ny]!=0) {
    				 idx = (idx+1) % 4;
    				    nx = x + dx[idx];
    				    ny = y + dy[idx];
    			}
    			x = nx;
    			y = ny;
    			
    		}
    		System.out.println("#"+tc);
    		for(int i =0;i<n;i++) {
    			for(int j=0;j<n;j++) {
    				System.out.print(num[i][j]+" ");
    			}
    			System.out.println();
    		}
    		
    		
    	}
    	
    }
}
