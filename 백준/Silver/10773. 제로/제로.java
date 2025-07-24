

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= K; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                if(stack.isEmpty()){
                    continue;
                }
                else{
                    stack.pop();
                }
            }
            else{
                stack.push(n);
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }

}
