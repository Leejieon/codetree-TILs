import java.util.*;
import java.io.*;

public class Main {

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int N, K;
    static int[][] graph, hurt;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        hurt = new int[N][N];
        visited = new boolean[N][N];

        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
                
                if(graph[y][x] == 0) {
                    hurt[y][x] = -1;
                } else if(graph[y][x] == 2) {
                    queue.offer(new int[]{y, x});
                    visited[y][x] = true;
                }
            }
        }

        bfs();

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(graph[y][x] == 1 && !visited[y][x]) {
                    sb.append(-2);
                } else {
                    sb.append(hurt[y][x]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if(isOutOfBound(ny, nx)) continue;
                if(visited[ny][nx]) continue;
                if(graph[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                hurt[ny][nx] = hurt[point[0]][point[1]] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }
}