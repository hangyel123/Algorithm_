import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    
    
    public int solution(int[][] maps) {
        int n = maps.length;  //행
        int m = maps[0].length; //렬
        
        visited = new boolean[n][m];
        
         
        int answer = 0;
        
        int[] startpos = {0,0}; 
        visited[0][0]= true;
        answer = bfs(startpos, maps, n, m);
        return answer;
    }
    
    public int bfs(int[] pos, int[][] maps, int n,int m){
        int xpos = pos[0];
        int ypos = pos[1];
        
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{xpos, ypos, 1});
        
        while(!q.isEmpty()){
            int[] cpos = q.poll();
            int xcpos = cpos[0];
            int ycpos = cpos[1];
            int cnt = cpos[2];
            
            if(xcpos == n -1 && ycpos == m-1){
                return cnt;
            }         
            for(int d =0;d<4;d++){
                int xn = xcpos +dx[d];
                int yn = ycpos +dy[d];
                
                if(xn >= 0 && xn < n && yn >= 0 && yn < m && maps[xn][yn] == 1 && !visited[xn][yn]){
                    visited[xn][yn] = true;
                    q.offer(new int[]{xn,yn,cnt+1});
                }
            }
        
            
        }
        return -1;    
    }
    
}