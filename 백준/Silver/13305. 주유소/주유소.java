import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 도시 개수

        // 도로 길이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        // 주유소 가격 입력
        st = new StringTokenizer(br.readLine());
        long[] price = new long[N];
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minPrice = price[0]; // 처음 도시의 주유소 가격

        for (int i = 0; i < N - 1; i++) {
            // 지금까지의 최소 가격 유지
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            // 거리 × 최소가격 = 비용
            totalCost += minPrice * distance[i];
        }

        System.out.println(totalCost);
    }
}
