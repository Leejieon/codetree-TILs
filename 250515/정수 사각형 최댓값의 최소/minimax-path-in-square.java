import java.util.*;
import java.io.*;

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

        int[][] dp = new int[N][N];
        dp[0][0] = graph[0][0];
        for(int x = 1; x < N; x++) {
            dp[0][x] = Math.max(graph[0][x], dp[0][x - 1]);
        }
        for(int y = 1; y < N; y++) {
            dp[y][0] = Math.max(graph[y][0], dp[y - 1][0]);
        }

        for(int y = 1; y < N; y++) {
            for(int x = 1; x < N; x++) {
                dp[y][x] = Math.min(
                    Math.max(graph[y][x], dp[y - 1][x]),
                    Math.max(graph[y][x], dp[y][x - 1])
                );
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}