import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 물건 개수
			int K = Integer.parseInt(st.nextToken()); // 가방의 부피

			int[] weights = new int[N + 1];
			int[] prices = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				weights[i] = Integer.parseInt(st.nextToken());
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= K; w++) {
					if (w >= weights[i]) { // 넣을 수 있는 경우
						dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-weights[i]]+prices[i]); //안넣는 경우와 넣는 경우 가치 비교
					}
					else { //못 넣는 경우
						dp[i][w] = dp[i-1][w];
					}
					
					
				}
			}
			System.out.println("#"+t+" "+dp[N][K]);
		}

	}
}
