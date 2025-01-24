import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        int[] jumps = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            jumps[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 101);
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = N; j > i; j--) {
                if(j - i <= jumps[i]) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }

        System.out.println(dp[N] == 101 ? -1 : dp[N]);
    }
}