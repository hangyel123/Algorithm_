import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine().trim());

			int[] dp = new int [Math.max(n+1,4)];
			Arrays.fill(dp, 0);
			if (n >= 1) dp[1] = 1;
			if (n >= 2) dp[2] = 2;
			if (n >= 3) dp[3] = 4;
			
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[n]);
		}

	}
}
