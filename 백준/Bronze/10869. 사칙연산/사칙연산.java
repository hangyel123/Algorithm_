
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int a=0,b=0;
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	a= Integer.parseInt(st.nextToken());
    	b= Integer.parseInt(st.nextToken());
    	
    	
    	System.out.println(a+b);
    	System.out.println(a-b);
    	System.out.println(a*b);
    	System.out.println(a/b);
    	System.out.println(a%b);
    }
 }