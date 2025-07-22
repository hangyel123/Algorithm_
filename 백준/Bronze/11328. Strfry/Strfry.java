

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str1= st.nextToken();
            String str2= st.nextToken();

            int[] alpha1 = new int[26];
            int[] alpha2 = new int[26];

            for(char c : str1.toCharArray()) {
                alpha1[c - 'a']++;
            }
            for(char c : str2.toCharArray()) {
                alpha2[c - 'a']++;
            }

            boolean isSame = true;
            for(int i = 0; i < 26; i++) {
                if(alpha1[i] != alpha2[i]) {
                    isSame=false;
                    break;
                }
            }

            System.out.println(isSame ? "Possible":"Impossible");
        }


    }
}
