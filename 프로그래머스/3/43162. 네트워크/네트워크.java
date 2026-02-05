import java.util.*;


class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i<n;i++){
            if(!visited[i]){
                answer++;
                bfs(i,computers, n);
            }
        }
        
        return answer;
    }
    public void bfs(int i, int[][] computers, int n){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(i);
        visited[i] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int a = 0; a<n;a++){
                if(!visited[a] && computers[cur][a] == 1){
                    visited[a] = true;
                    q.offer(a);
                }
            }
        }

        
    }
    
}