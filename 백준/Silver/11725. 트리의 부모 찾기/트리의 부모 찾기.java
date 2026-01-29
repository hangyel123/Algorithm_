
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine().trim());
    	
    	ArrayList<Integer>[] graph = new ArrayList[N+1];
    	for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
    	
    	for(int i = 0;i<N-1;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph[a].add(b);
        	graph[b].add(a);
    	}
    	int root = 1;
    	int[] parents = new int[N+1];
    	boolean[] isVisited = new boolean[N+1];
    
    	ArrayDeque<Integer> queue= new ArrayDeque<>();
    	queue.offer(root);
    	isVisited[root] = true;
    	
    	while(!queue.isEmpty()) {
    		int cur = queue.poll();
    		for(int nxt : graph[cur]) {
    			if(!isVisited[nxt]) {
    				isVisited[nxt] = true;
    				parents[nxt] = cur;
    				queue.offer(nxt);
    			}
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = 2; i<=N;i++) {
    		sb.append(parents[i]).append('\n');
    	}
    	System.out.println(sb);
    }
}