import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];

        for(int i=0;i<N;i++){
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < N; i++) {
            int current = heights[i];

            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            // stack에 남아있는 빌딩들은 current보다 높은 빌딩들
            count += stack.size(); // 이 빌딩들이 현재 빌딩을 볼 수 있음

            // 현재 빌딩을 stack에 추가
            stack.push(current);
        }

        System.out.println(count);
    }
}
