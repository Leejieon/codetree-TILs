import java.util.*;
import java.io.*;

public class Main {

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int N, K, U, D;
    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<Integer> counts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(!visited[y][x]) {
                    counts.add(bfs(y, x));                    
                }
            }
        }

        Collections.sort(counts, Collections.reverseOrder());
        int ans = 0;
        for(int i = 0; i < K; i++) {
            ans += counts.get(i);
        }
        System.out.println(ans);
    }

    static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        
        int rst = 1;
        visited[y][x] = true;
        queue.offer(new int[]{y, x});
        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if(isOutOfBound(ny, nx)) continue;
                if(visited[ny][nx]) continue;

                int diff = Math.abs(graph[point[0]][point[1]] - graph[ny][nx]);
                if(diff < U || diff > D) continue;
                
                visited[ny][nx] = true;
                rst++;
                queue.offer(new int[]{ny, nx});
            }
        }
        return rst;
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }
}