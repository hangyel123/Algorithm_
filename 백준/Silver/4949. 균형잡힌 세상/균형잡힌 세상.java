

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();
            if(s.equals("."))break;
            if(isBalanced(s))System.out.println("yes");
            else System.out.println("no");
        }
    }
    public static boolean isBalanced(String line){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = line.toCharArray();
        for(char c: chars){
            if(c == '[' || c=='('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '(')return false;
                stack.pop();
            }else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '[')return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}
