import java.util.*;
import java.io.*;

public class Main {
    
    static final int INF = (int)1e9;

    static int N, M, A, B;
    static int[] distance;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from][to] = cost;
            graph[to][from] = cost;
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[B] = 0;

        visited = new boolean[N + 1];
        dijkstra(B);

        sb.append(distance[A]).append("\n");
        int idx = A;
        sb.append(idx).append(" ");
        while(idx != B) {
            for(int i = 1; i <= N; i++) {
                if(graph[i][idx] == 0) continue;
                if(distance[i] + graph[i][idx] == distance[idx]) {
                    idx = i;
                    break;
                }
            }
            sb.append(idx).append(" ");
        }
        System.out.print(sb);
    }

    static void dijkstra(int source) {
        for(int i = 1; i <= N; i++) {
            int minIdx = -1;
            for(int j = 1; j <= N; j++) {
                if(visited[j]) continue;

                if(minIdx == -1 || distance[minIdx] > distance[j]) {
                    minIdx = j;
                }
            }

            visited[minIdx] = true;

            for(int j = 1; j <= N; j++) {
                if(graph[minIdx][j] == 0) continue;

                if(distance[j] > distance[minIdx] + graph[minIdx][j]) {
                    distance[j] = distance[minIdx] + graph[minIdx][j];
                }
            }
        }
    }
}