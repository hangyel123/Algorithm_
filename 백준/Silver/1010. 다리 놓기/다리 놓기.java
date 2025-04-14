import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] dp;
	
	static int comb(int n, int r) {
		if(dp[n][r] >0) return dp[n][r];
		if(n == r || r == 0)return dp[n][r] = 1;
		
		return dp[n][r] = comb(n-1,r-1)+ comb(n-1,r);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			dp = new int[30][30];
			
			System.out.println(comb(M,N));
		}
		
	}
}
