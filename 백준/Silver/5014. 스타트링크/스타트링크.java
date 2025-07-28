
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //총 층
        int F = Integer.parseInt(st.nextToken());
        //강호 위치
        int S = Integer.parseInt(st.nextToken());
        //회사 위치
        int G = Integer.parseInt(st.nextToken());
        //위로 가는 버튼
        int U = Integer.parseInt(st.nextToken());
        //아래로 가는 버튼
        int D = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[F+1];

        queue.offer(new int[]{S,0});
        visited[S] = true;

        while(!queue.isEmpty()){
            int[] now= queue.poll();
            int cur = now[0];
            int cnt = now[1];

            if(cur == G){
                System.out.println(cnt);
                return;
            }
            if(cur + U <= F && !visited[cur+U]) {
                queue.offer(new int[]{cur + U, cnt+1});
                visited[cur+U] = true;

            }
            if(cur - D >= 1 && !visited[cur-D]) {
                queue.offer(new int[]{cur - D, cnt+1});
                visited[cur-D] = true;

            }

        }
        System.out.println("use the stairs");

    }
}
