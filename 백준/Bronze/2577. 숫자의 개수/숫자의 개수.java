import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a * b * c;

        int[] count = new int[10]; // 숫자 0~9의 개수 저장

        String resultStr = String.valueOf(result);
        for (int i = 0; i < resultStr.length(); i++) {
            int digit = resultStr.charAt(i) - '0'; // 문자 → 숫자
            count[digit]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}
