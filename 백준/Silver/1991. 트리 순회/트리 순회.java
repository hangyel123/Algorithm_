

import java.io.*;
import java.util.*;

public class Main {
	static int[] left = new int[26];
	static int[] right = new int[26];
	
	static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
			
		Arrays.fill(left, -1);
		Arrays.fill(right, -1);
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char p = st.nextToken().charAt(0);
			char le = st.nextToken().charAt(0);
			char ri = st.nextToken().charAt(0);
			
			int pn = p - 'A';
			if(le != '.')left[pn] = le - 'A';
			if(ri != '.')right[pn] = ri - 'A';
		}
		
		int root = 0;
		preOrder(root);
		inOrder(root);
		postOrder(root);
		
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}
	
	static void preOrder(int cur) {
		if(cur == -1) return;
		pre.append((char)(cur+'A'));
		preOrder(left[cur]);
		preOrder(right[cur]);
	}
	
	static void inOrder(int cur) {
		if(cur == -1) return;
		inOrder(left[cur]);
		in.append((char)(cur+'A'));
		inOrder(right[cur]);
	}

	
	static void postOrder(int cur) {
		if(cur == -1) return;
		postOrder(left[cur]);
		postOrder(right[cur]);
		post.append((char)(cur+'A'));
	}

	
}