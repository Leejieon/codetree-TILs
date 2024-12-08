import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Edge>[] edges;
    static boolean[] visited;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        edges = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[x].add(new Edge(y, cost));
            edges[y].add(new Edge(x, cost));
        }

        distances = new int[N + 1];
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        int farthestNode = -1;
        int farthestDistance = -1;
        for(int i = 1; i <= N; i++) {
            if(farthestDistance < distances[i]) {
                farthestDistance = distances[i];
                farthestNode = i;
            }
        }

        distances = new int[N + 1];
        visited = new boolean[N + 1];
        visited[farthestNode] = true;
        dfs(farthestNode, 0);

        farthestDistance = -1;
        for(int d : distances) {
            farthestDistance = Math.max(farthestDistance, d);
        }

        System.out.println(farthestDistance);
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