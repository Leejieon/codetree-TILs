import java.util.*;
import java.io.*;

public class Main {

    static final int INF = (int)1e9;

    static int N, M, K;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[node1].add(new Node(node2, cost));
            graph[node2].add(new Node(node1, cost));
        }

        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[K] = 0;

        visited[K] = true;
        dijkstra(K);

        for(int i = 1; i <= N; i++) {
            if(distance[i] == INF) {
                sb.append(-1);
            } else {
                sb.append(distance[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int source) {
        PriorityQueue<Element> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        for(int i = 1; i <= N; i++) {
            pq.offer(new Element(i, distance[i]));
        }

        while(!pq.isEmpty()) {
            int minDist = pq.peek().cost;
            int minIdx = pq.peek().node;
            pq.poll();

            if(minDist != distance[minIdx]) continue;

            for(Node node : graph[minIdx]) {
                if(visited[node.index]) continue;

                int newDist = distance[minIdx] + node.cost;
                if(distance[node.index] > newDist) {
                    distance[node.index] = newDist;
                    visited[node.index] = true;
                    pq.offer(new Element(node.index, newDist));
                }
            }
        }
    }

    static class Node {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static class Element {
        int node, cost;

        Element(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}