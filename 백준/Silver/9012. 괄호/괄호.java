
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int tc = Integer.parseInt(br.readLine());
    	
    	for(int test =1 ; test<=tc;test++) {
    		ArrayDeque<Character> stack = new ArrayDeque<>();
    		char[] str = br.readLine().toCharArray();    	
    		boolean isValid = true;
    		
    		for(int i=0;i<str.length;i++) {
    			if(str[i] == '(') {
    				stack.push('(');
    			}
    			else { 
    				if(stack.isEmpty()) {
    					isValid = false;
    					break;
    					}
    				stack.pop();		
    				}
    	
    		}
    		if(!stack.isEmpty()) {
    			isValid = false; 
    		}
    		System.out.println(isValid?"YES":"NO");
    	}
    
    }
}
