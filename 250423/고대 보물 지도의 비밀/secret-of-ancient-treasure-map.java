import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++){
                dp[i][j] = -1000000009;
            }
        }

        int ans = -1000000009;
        for(int i = 1; i <= N; i++) {
            if(numbers[i] >= 0) {
                for(int j = 0; j <= K; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + numbers[i], dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
            } else {
                for(int j = 1; j <= K; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + numbers[i], dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans);
    }
}