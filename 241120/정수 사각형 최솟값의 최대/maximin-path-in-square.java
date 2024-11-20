import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        init();
        for(int y = 1; y < N; y++) {
            for(int x = 1; x < N; x++) {
                dp[y][x] = Math.max(
                    Math.min(dp[y - 1][x], graph[y][x]),
                    Math.min(dp[y][x - 1], graph[y][x])
                );
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    static void init() {
        dp[0][0] = graph[0][0];
        for(int y = 1; y < N; y++) {
            dp[y][0] = Math.min(dp[y - 1][0], graph[y][0]);
        }

        for(int x = 1; x < N; x++) {
            dp[0][x] = Math.min(dp[0][x - 1], graph[0][x]);
        }
    }
}