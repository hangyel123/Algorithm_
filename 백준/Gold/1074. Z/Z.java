import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count =0;
	
	public static int count(int n,int r, int c) {
		if(n==0)return 0;
		
		int half= 1<<(n-1);
		int area = half * half;
		
		if (r < half && c < half) { // 1사분면
            return count(n - 1, r, c);
        } else if (r < half && c >= half) { // 2사분면
            return area + count(n - 1, r, c - half);
        } else if (r >= half && c < half) { // 3사분면
            return 2 * area + count(n - 1, r - half, c);
        } else { // 4사분면
            return 3 * area + count(n - 1, r - half, c - half);
        }
		
	}
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int r = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        
	        System.out.println(count(N,r,c));
		
	}
}
