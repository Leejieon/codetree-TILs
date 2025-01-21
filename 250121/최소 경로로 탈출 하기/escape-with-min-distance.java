import java.util.*;
import java.io.*;

public class Main {

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int N, M;
    static int[][] graph, dist;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
        System.out.println(dist[N - 1][M - 1]);
    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.offer(new int[]{y, x});

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if(isOutOfBound(ny, nx)) continue;
                if(visited[ny][nx]) continue;
                if(graph[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                dist[ny][nx] = dist[point[0]][point[1]] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }
}