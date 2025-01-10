import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        // for(int[] d : dp) {
        //     Arrays.fill(d, -1);
        // }

        dp[0][0] = 1;
        for(int y = 1; y < N; y++) {
            for(int x = 1; x < M; x++) {
                for(int i = 0; i < y; i++) {
                    for(int j = 0; j < x; j++) {
                        if(graph[i][j] < graph[y][x]) {
                            dp[y][x] = Math.max(dp[y][x], dp[i][j] + 1);
                        }
                    }
                }
            }
        }

        int rst = -1;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                rst = Math.max(rst, dp[y][x]);
            }
        }

        System.out.println(rst);
    }
}