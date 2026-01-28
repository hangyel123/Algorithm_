

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] lines = new int[K];
		
		for(int i=0;i<K;i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lines);
		long lo = 1;
		long hi = lines[K-1];
		long ans = 0;
		
		while(lo<=hi) {
			long cnt = 0;
			long mid = (lo+hi)/2;
			for(long line :lines) {
				if(line >= mid) {
					cnt += (line/mid);
				}
			}
			if(cnt >= N) {
				ans = mid;
				lo = mid +1;
			}else {
				hi = mid -1;
			}
			
		}
	System.out.println(ans);
	}
}