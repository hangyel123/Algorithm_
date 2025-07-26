

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.startsWith("push")) {
                int n = Integer.parseInt(str.split(" ")[1]);
                queue.offer(n);
            } else if (str.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else{
                    int num = queue.poll();
                    sb.append(num).append("\n");
                }
            }else if (str.equals("size")) {
                int num = queue.size();
                sb.append(num).append("\n");
            }else if (str.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }else if (str.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else{
                    int num = queue.peekFirst();
                    sb.append(num).append("\n");
                }
            }else if (str.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else{
                    int num = queue.peekLast();
                    sb.append(num).append("\n");
                }
            }



        }
        System.out.println(sb);
    }
}