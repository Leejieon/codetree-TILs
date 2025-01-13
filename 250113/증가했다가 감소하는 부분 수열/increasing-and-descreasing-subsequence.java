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

        int[][] dp = new int[N][2];
        dp[0][0] = 1; // 증가하고 있는 경우
        dp[0][1] = 1; // 감소하고 있는 경우
        for(int i = 1; i < N; i++) {
            // 증가하고 있는 경우
            for(int j = 0; j < i; j++) {
                if(numbers[j] < numbers[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }

            // 감소하고 있는 경우
            for(int j = 0; j < i; j++) {
                if(numbers[j] > numbers[i]) {
                    dp[i][1] = Math.max(dp[i][1],
                        Math.max(dp[j][0] + 1, dp[j][1] + 1));
                }
            }
        }

        int rst = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                rst = Math.max(rst, dp[i][j]);
            }
        }

        System.out.println(rst);
	}
}