import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        dp[0] = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        System.out.println(ans);
    }
}