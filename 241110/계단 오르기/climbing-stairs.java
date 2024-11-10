import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
        }

        System.out.println(dp[N]);
    }
}