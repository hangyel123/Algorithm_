import java.util.*;
import java.io.*;
class Solution {
    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,-1,1}; //상하좌우
    static boolean[][] visited;
    
    
    public int solution(int[][] maps) {
     
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new boolean[n][m];

        return bfs(maps, visited,n ,m );
    }
    
    static int bfs(int[][] maps, boolean[][] visited,int n,int m){
        visited[0][0] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0, 1});
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int xpos = pos[0];
            int ypos = pos[1];
            int dist = pos[2];
            
            if(xpos== n-1 && ypos == m-1) return dist;
            for(int d = 0;d<4;d++){
                int nx = xpos +dx[d];
                int ny = ypos +dy[d];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny,dist+1});
                    }
                }
            }
        }
        return -1;
    }
    
}