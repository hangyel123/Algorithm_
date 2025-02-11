import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		int total = 0; 
		String[] inputA = br.readLine().split(" ");
		for(int i=0; i<N;i++) {
			A[i] = Integer.parseInt(inputA[i]);
		}
		String[] inputB = br.readLine().split(" ");
		for(int i=0; i<N;i++) {
			B[i] = Integer.parseInt(inputB[i]);
		}
		Arrays.sort(A);
		Arrays.sort(B,Collections.reverseOrder());
		
		for(int i = 0;i<N;i++) {
			total += (A[i]*B[i]);
		}
		
		System.out.println(total);
	}
 }
