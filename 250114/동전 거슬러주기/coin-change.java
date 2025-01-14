import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[M + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= M; i++) {
            for(int j = 0; j < N; j++) {
                if(i >= coins[j]) {
                    if(dp[i - coins[j]] == -1) continue;

                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        if(dp[M] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[M]);
        }
        
    }
}