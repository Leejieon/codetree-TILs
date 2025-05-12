import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][N][101];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 1; k <= 100; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        dp[0][0][graph[0][0]] = graph[0][0];

        // 최상단
        for(int j = 1; j < N; j++) {
            for(int k = 1; k <= 100; k++) {
                dp[0][j][Math.min(k, graph[0][j])] = Math.min(
                    dp[0][j][Math.min(k, graph[0][j])],
                    Math.max(dp[0][j - 1][k], graph[0][j])
                );
            }
        }

        for(int i = 1; i < N; i++) {
            for(int k = 1; k <= 100; k++) {
                dp[i][0][Math.min(k, graph[i][0])] = Math.min(
                    dp[i][0][Math.min(k, graph[i][0])],
                    Math.max(dp[i - 1][0][k], graph[i][0])
                );
            }  
        }

        for(int i = 1; i < N; i++) {
            for(int j = 1; j < N; j++) {
                for(int k = 1; k <= 100; k++) {
                    dp[i][j][Math.min(k, graph[i][j])] = Math.min(
                        dp[i][j][Math.min(k, graph[i][j])],
                        Math.max(Math.min(dp[i - 1][j][k], dp[i][j - 1][k]), graph[i][j])
                    );
                }
            }     
        }

        int ans = Integer.MAX_VALUE;
        for(int k = 1; k <= 100; k++) {
            if(dp[N - 1][N - 1][k] != Integer.MAX_VALUE) {
                ans = Math.min(ans, dp[N - 1][N - 1][k] - k);
            }
        }
        System.out.println(ans);
    }
}