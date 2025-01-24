import java.util.*;
import java.io.*;

public class Main {

    static final int[] dy = {1, 0};
    static final int[] dx = {0, 1};    

    static int N, M;
    static boolean complete;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        complete = false;
        dfs(0, 0);

        System.out.println(complete ? 1 : 0);
    }

    static void dfs(int y, int x) {
        if(complete) return;
        if(y == N - 1 && x == M - 1) {
            complete = true;
            return;
        }

        for(int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(isOutOfBound(ny, nx)) continue;
            if(visited[ny][nx]) continue;
            if(graph[ny][nx] == 0) continue;

            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }
}