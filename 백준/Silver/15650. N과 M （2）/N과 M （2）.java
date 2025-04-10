import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;


public class Main {
	static int N,M;
	static int[] result;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		
		comb(0,1);
	}
	
	
	static void comb(int depth, int start) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<M;i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		for(int i = start;i<=N;i++) {
			result[depth] = i;
			comb(depth+1,i+1);
		}	
	}
}
