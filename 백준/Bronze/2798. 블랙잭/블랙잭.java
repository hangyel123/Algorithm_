
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
        StringTokenizer st = new StringTokenizer(br.readLine());
    	
        N = Integer.parseInt(st.nextToken()); // 배열 크기
        M = Integer.parseInt(st.nextToken()); // 목표 값
        arr = new int[N];
    	
        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        // 재귀 호출로 조합 생성 및 최대값 계산
        combination(0, 0, 0);

        System.out.println(max); // 결과 출력
    }

    // 재귀를 이용한 조합 함수: count는 선택된 숫자 개수, start는 시작 인덱스, sum은 현재까지의 합
    static void combination(int count, int start, int sum) {
        if (count == 3) { // 숫자 3개를 선택한 경우
            if (sum <= M) { // 합이 M 이하일 때만 고려
                max = Math.max(max, sum); // 최대값 갱신
            }
            return;
        }

        for (int i = start; i < N; i++) {
            combination(count + 1, i + 1, sum + arr[i]); // 다음 숫자를 선택
        }
    }
}