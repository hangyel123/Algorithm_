

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String command = br.readLine();



            if(command.startsWith("push")){
                int num = Integer.parseInt(command.split(" ")[1]);
                stack.push(num);
            }else if(command.equals("pop")){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(stack.pop()).append("\n");
                }
            }
            else if(command.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(command.equals("top")){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(stack.peek()).append("\n");
                }
            }


        }
        System.out.println(sb);
    }
}
