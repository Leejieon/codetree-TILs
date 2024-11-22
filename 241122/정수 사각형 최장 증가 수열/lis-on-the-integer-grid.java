import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph, dp;
    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

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
        visited = new boolean[N][N];
        int ans = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(!visited[y][x]) {
                    visited[y][x] = true;
                    ans = Math.max(ans, dfs(y, x));
                }
            }
        }

        System.out.println(ans);
    }

    static int dfs(int y, int x) {
        if(dp[y][x] != 0) {
            return dp[y][x];
        }

        int rst = 0;
        for(int cand = 0; cand < 4; cand++) {
            int ny = y + dy[cand];
            int nx = x + dx[cand];

            if(isOutOfBound(ny, nx)) continue;
            if(graph[y][x] >= graph[ny][nx]) continue;
            if(visited[ny][nx]) {
                rst = Math.max(rst, dp[ny][nx]);
            } else {
                visited[ny][nx] = true;
                rst = Math.max(rst, dfs(ny, nx));
            }
        }

        return dp[y][x] = rst + 1;
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }
}