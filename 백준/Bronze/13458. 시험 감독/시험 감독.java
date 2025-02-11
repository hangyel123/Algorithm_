import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시험장의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 각 시험장의 응시자 수 입력
        int[] students = new int[N];
        StringTokenizer sc = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(sc.nextToken());
        }

        // 총감독관(B)과 부감독관(C)의 감시 가능 인원 입력
        String[] capacities = br.readLine().split(" ");
        int B = Integer.parseInt(capacities[0]);
        int C = Integer.parseInt(capacities[1]);

        // 필요한 감독관 수 계산
        long teacher = 0; // 결과가 클 수 있으므로 long 타입 사용

        for (int i = 0; i < N; i++) {
            // 총감독관은 반드시 1명 필요
            teacher++;

            // 남은 학생 수 계산
            int remainingStudents = students[i] - B;

            if (remainingStudents > 0) {
                // 부감독관의 수 계산 (정수 나눗셈 사용)
                teacher += (remainingStudents / C);
                if (remainingStudents % C != 0) { // 나머지가 있으면 부감독관 1명 추가
                    teacher++;
                }
            }
        }

        // 결과 출력
        System.out.println(teacher);
    }
}