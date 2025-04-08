import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T ; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int[] dp = new int[N];
			
			for(int i=0;i<N;i++) {
				dp[i] = 1;
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
				max = Math.max(dp[i],max);
				
			}
			
			
			System.out.println("#"+t+" "+max);
		}
		
	}
}
