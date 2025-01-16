import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());    
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[M + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            for(int w = 1; w <= M; w++) {
                if(w >= weights[i]) {
                    if(dp[w - weights[i]] == -1) continue;
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                } else {
                    dp[w] = dp[w - 1];
                }
            }
        }

        System.out.println(dp[M]);
    }
}