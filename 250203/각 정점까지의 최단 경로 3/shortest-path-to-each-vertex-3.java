import java.util.*;
import java.io.*;

public class Main {

    static final int INF = (int)1e9;

    static int N, M;
    static int[] distance;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from][end] = cost;
        }

        dijkstra(1);

        for(int i = 2; i <= N; i++) {
            if(distance[i] == INF) {
                sb.append(-1);
            } else {
                sb.append(distance[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        Arrays.fill(distance, INF);
        distance[start] = 0;

        for(int i = 1; i <= N; i++) {
            int minIndex = -1;
            for(int j = 1; j <= N; j++) {
                if(visited[j]) continue;
                if(minIndex == -1 || distance[minIndex] > distance[j]) minIndex = j;
            }

            visited[minIndex] = true;

            for(int j = 1; j <= N; j++) {
                if(graph[minIndex][j] == 0) continue;

                distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
            }
        }
    }
}