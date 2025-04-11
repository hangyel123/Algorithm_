import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		back(0,1);
		bw.flush();
		bw.close(); 
	}
	static void back(int depth, int start) throws IOException {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				bw.write(result[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			result[depth]= i;
			back(depth+1,i);
		}
	}
	

}
