import java.util.*;
import java.io.*;

public class Main {

    static int N, K, answer;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for(int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            queue.offer(new int[]{y, x});
            visited[y][x] = true;
            answer++;
        }

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            
            for(int d = 0; d < 4; d++) {
                int ny = point[0] + dy[d];
                int nx = point[1] + dx[d];

                if(isOutOfBound(ny, nx)) continue;
                if(visited[ny][nx]) continue;
                if(graph[ny][nx] == 1) continue;

                answer++;
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 1 || x < 1 || y >= N + 1 || x >= N + 1;
    }
}