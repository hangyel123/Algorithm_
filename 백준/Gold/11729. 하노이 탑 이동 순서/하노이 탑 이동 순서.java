import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            cnt++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, to, via);
        cnt++;
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);

        System.out.println(cnt);
        System.out.print(sb);  // ✅ println -> print 로 수정!
    }
}
