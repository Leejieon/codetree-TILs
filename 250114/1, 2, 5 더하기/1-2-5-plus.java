import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[]{1, 2, 5};

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                if(i > numbers[j]) {
                    dp[i] += dp[i - numbers[j]] % 10007;
                }
            }
        }

        System.out.println(dp[N]);
    }
}