

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] heights = new int[N];
        int maxHeight = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            heights[i] = h;
            if (h > maxHeight) maxHeight = h;
        }
        int lo = 0;
        int hi = maxHeight;
        int answer = 0;

        while(lo<=hi){
            int mid= (lo+hi)/2;

            long wood = 0;
            for(int h:heights){
                if(h>mid) wood += (h-mid);
            }

            if(wood >= M){
                answer = mid;
                lo = mid + 1;
            }else{
                hi = mid -1;
            }
        }
        System.out.println(answer);
    }
}