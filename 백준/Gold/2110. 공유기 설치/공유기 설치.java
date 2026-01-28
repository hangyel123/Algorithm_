

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long[] heights= new long[N];
		
		for(int i =0; i<N;i++) {
			heights[i] = Long.parseLong(br.readLine().trim());
		}
		Arrays.sort(heights);
		
		long lo = 0;
		long hi = heights[N-1] - heights[0];
		long ans = 0;
				
		while(lo<=hi) {
			long mid = (hi + lo)/2;
			if(isCanLocate(heights, C, mid)) {
				ans = mid;
				lo = mid +1;
			}else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	
	public static boolean isCanLocate(long[] pos, int C, long dist) {
		int cnt = 1;
		long last = pos[0];
		
		for(int i=1;i<pos.length;i++) {
			if(pos[i]-last >= dist) {
				cnt++;
				last = pos[i];
			}if(cnt >= C) {
				return true;
			}
		}
		return false;
	}
}