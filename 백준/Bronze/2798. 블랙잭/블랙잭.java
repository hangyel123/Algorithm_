
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] arr =new int[N];
    	
    	StringTokenizer s= new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(s.nextToken());
    	}
    	
    	int max = 0;
    	
    	for(int i=0;i<N-2;i++) {
    		for(int j=i+1;j<N-1;j++) {
    			for(int q=j+1;q<N;q++) {
    				if(arr[i]+arr[j]+arr[q]<=M) {
    					int sum = arr[i]+arr[j]+arr[q];
    					max = Math.max(max, sum);
    				}
    			}
    		}
    	}
    	System.out.println(max);

    	
    	
    }
 }