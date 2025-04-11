import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result, arr;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		comb(0,0);
		
		bw.flush();
		bw.close();
		
	}
	
	static void comb(int depth, int start) throws IOException {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				bw.write(result[i] + " ");
			}
			bw.newLine();
			return;
		}
		for(int i= start;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				comb(depth+1,i+1);
				visited[i] = false;
			}
		}
	}
}
