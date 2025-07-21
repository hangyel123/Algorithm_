
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();

        int[] count = new int[10]; // 숫자 0~9 개수 저장
        for(int i=0;i<roomNumber.length();i++){
            int digit = roomNumber.charAt(i) - '0';
            count[digit]++;
        }
        int sixNine = count[6] + count[9];

        int setsForSixNine = (sixNine+1)/2;
        count[6]= count[9] =setsForSixNine;

        int max = 0;

        for(int i=0;i<10;i++){
            max = Math.max(max, count[i]);
        }

        System.out.println(max);



    }
}
