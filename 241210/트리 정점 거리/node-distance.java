import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Edge>[] edges;
    static int[] distances;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, cost));
            edges[to].add(new Edge(from, cost));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            distances = new int[N + 1];
            visited = new boolean[N + 1];
            visited[from] = true;

            dfs(from, 0);
            
            System.out.println(distances[to]);
        }

    }

    static void dfs(int x, int distance) {
        for(Edge edge : edges[x]) {
            if(!visited[edge.node]) {
                visited[edge.node] = true;
                distances[edge.node] = distance + edge.cost;
                dfs(edge.node, distance + edge.cost);
            }
        }
    }

    static class Edge {
        int node;
        int cost;

        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}