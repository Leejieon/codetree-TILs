import java.util.*;
import java.io.*;

public class Main {

    static int N, ans;
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

        ans = 0;
        dp = new int[N][N];
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                visited = new boolean[N][N];
                
                visited[y][x] = true;
                ans = Math.max(ans, proceed(y, x));
            }
        }

        System.out.println(ans);
    }
 
    static int proceed(int y, int x) {
        if(dp[y][x] != 0) {
            return dp[y][x];
        }

        int rst = 1;
        int subRst = 0;
        for(int cand = 0; cand < 4; cand++) {
            int ny = y + dy[cand];
            int nx = x + dx[cand];

            if(isOutOfBound(ny, nx)) continue;
            if(visited[ny][nx]) continue;
            if(graph[y][x] >= graph[ny][nx]) continue;
            
            visited[ny][nx] = true;
            subRst = Math.max(subRst, proceed(ny, nx));
        }

        rst += subRst;
        dp[y][x] = rst;
        return dp[y][x];
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }
}