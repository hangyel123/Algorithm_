
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

       int[][] count = new int[2][7]; //성별 0~1, 학년1~6
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()); //0여, 1남
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            count[gender][grade]++;
        }

        int totalRooms = 0;
        for(int gender = 0;gender<=1;gender++){
            for(int grade=1;grade<=6;grade++){
                int studentcount = count[gender][grade];
                if(studentcount == 0) continue;
                totalRooms += studentcount/K;
                if(studentcount % K != 0) totalRooms++;
            }
        }
        System.out.println(totalRooms);
    }
}
