import java.util.*;
import java.io.*;

public class Main {

    static int N, maxNode, maxDistance;
    static ArrayList<Edge>[] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
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

        maxDistance = Integer.MIN_VALUE;
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(maxDistance);
    }

    static void dfs(int x, int distance) {
        for(Edge edge : edges[x]) {
            int y = edge.node;
            int cost = edge.cost;

            if(!visited[y]) {
                visited[y] = true;
                if(distance + cost > maxDistance) {
                    maxDistance = distance + cost;
                    maxNode = y;
                }
                dfs(y, cost + distance);
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