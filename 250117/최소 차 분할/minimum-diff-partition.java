import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N + 1];
        int M = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            M += numbers[i];
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][0] = true;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                // i 번째를 포함해서 j를 만든 경우
                if(j >= numbers[i] && dp[i - 1][j - numbers[i]]) {
                    dp[i][j] = true;
                } 

                // i 번째를 포함하지 않고 j를 만든 경우
                if(dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        int rst = Integer.MAX_VALUE;
        for(int i = 1; i < M; i++) {
            if(dp[N][i]) {
                rst = Math.min(rst, Math.abs(i - (M - i)));
            }
        }
        System.out.println(rst);
    }
}