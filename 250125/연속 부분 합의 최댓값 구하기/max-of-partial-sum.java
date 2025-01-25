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

        int[] dp = new int[N];
        dp[0] = numbers[0];

        for(int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
        }

        int rst = Integer.MIN_VALUE;
        for(int d : dp) {
            rst = Math.max(rst, d);
        }
        System.out.println(rst);
    }
}