

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long[] positions = new long[N];
		for(int i=0;i<N;i++) {
			positions[i] = Long.parseLong(br.readLine().trim());		
		}
		Arrays.sort(positions);
		
		long lo = 1;
		long hi = positions[N-1] - positions[0];
		long ans = 0;
		
		while(lo<=hi) {
			long mid = (lo+hi)/2;
			if(canInstall(positions, C, mid)) {
				ans = mid;
				lo = mid+1;
			}else {
				hi = mid -1;
			}
		}
		System.out.println(ans);
	}
	static boolean canInstall(long[] pos, int C,long dist) {
		int count = 1;
		long last = pos[0];
		
		for(int i = 1;i<pos.length;i++) {
			if(pos[i]-last >= dist) {
				count++;
				last = pos[i];
				
				if(count >= C) {
					return true;
				}
			}
		}
		return false;
	}
	
}
