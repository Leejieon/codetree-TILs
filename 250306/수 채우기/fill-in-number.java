import java.util.*;

public class Main {

    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i = 6; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[i], dp[i - 2] + 1), Math.min(dp[i], dp[i - 5] + 1));
        }

        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }
}