import java.util.*;
import java.io.*;

public class Main {
    
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int N, M;
    static int[][] graph, answer;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

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
        answer = new int[N][M];

        visited[0][0] = true;
        answer[0][0] = 1;
        queue.offer(new int[]{0, 0});
        bfs();

        System.out.println(answer[N - 1][M - 1] != 0 ? 1 : 0);
    }

    static void bfs() {
        int depth = 2;
        while(!queue.isEmpty()) {
            int y = queue.peek()[0];
            int x = queue.poll()[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(isOutOfBound(ny, nx)) continue;
                if(graph[ny][nx] == 0) continue;
                if(visited[ny][nx]) continue;

                push(ny, nx, depth);
            } 
            depth++;
        }
    }

    static void push(int y, int x, int depth) {
        answer[y][x] = depth;
        visited[y][x] = true;
        queue.offer(new int[]{y, x}); 
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }
}