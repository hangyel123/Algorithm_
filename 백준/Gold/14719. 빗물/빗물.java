import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // 각 칸에 대해 왼쪽 최대, 오른쪽 최대를 구하고 물 높이를 계산
        for(int i =1 ; i<W-1;i++) {
        	int lMax=0, rMax=0;
        	//왼쪽 최대 찾기
        	for(int j=0;j<i;j++) {
        		lMax = Math.max(lMax, height[j]);
        	}
        	//오른쪽 최대 찾기
        	for(int j=i+1;j<W;j++) {
        		rMax = Math.max(rMax, height[j]);
        	}
        	int ans = Math.min(lMax, rMax);
        	
        	if(ans > height[i]) {
        		answer+=(ans - height[i]);
        	}
        }

        System.out.println(answer);
    }
}