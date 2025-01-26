import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] coins = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][4];
        dp[1][1] = coins[1];
        dp[2][0] = coins[2];
        dp[2][2] = coins[1] + coins[2];

        for(int i = 3; i <= N; i++) {
            for(int j = 0; j <= 3; j++) {
                if(dp[i - 2][j] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + coins[i]);
                }
                if(j > 0 && dp[i - 1][j - 1] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + coins[i]);
                }
            }
        }

        int rst = 0;
        for(int i = 0; i <= 3; i++) {
            rst = Math.max(rst, dp[N][i]);
        }
        System.out.println(rst);
        
    }
}