import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        int total = 0;
        int[] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            total += numbers[i];
        }

        if(total % 2 == 1) {
            System.out.println("No");
            return;
        }

        boolean[][] dp = new boolean[N + 1][total + 1];
        dp[0][0] = true;
        for(int i = 1; i <= N; i++) {
            dp[i][0] = true;
            for(int s = 1; s <= total; s++) {
                if(s >= numbers[i]) {
                    dp[i][s] = dp[i - 1][s - numbers[i]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }

        System.out.println(dp[N][total/2] ? "Yes" : "No");
    }
}