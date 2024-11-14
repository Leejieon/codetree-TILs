import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];

        for(int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < n; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        for(int y = 1; y <= n; y++) {
            for(int x = n - 1; x >= 0; x--) {
                if(y == 1) {
                    dp[y][x] = dp[y][x + 1] + graph[y][x];
                    continue;
                }
                dp[y][x] = Math.min(dp[y][x + 1], dp[y - 1][x]) + graph[y][x];
            }
        }

        System.out.println(dp[n][0]);
    }
}