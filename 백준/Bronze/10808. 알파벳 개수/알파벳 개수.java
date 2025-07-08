import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] counts = new int[26];

        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            counts[ch- 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<26;i++){
            sb.append(counts[i]).append(" ");
        }


        System.out.println(sb.toString().trim());

    }
}
