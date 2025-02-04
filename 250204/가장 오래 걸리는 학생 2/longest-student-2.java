import java.util.*;
import java.io.*;

public class Main {

    static final int INF = (int)1e9;

    static int N, M;
    static int[] distance;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[to].add(new Node(from, cost));
        }

        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[N] = 0;

        dijkstra(N);

        int rst = 0;
        for(int i = 1; i <= N; i++) {
            if(distance[i] != INF) {
                rst = Math.max(rst, distance[i]);
            }
        }
        System.out.println(rst);
    }

    static void dijkstra(int source) {
        PriorityQueue<Element> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.offer(new Element(source, 0));
        while(!pq.isEmpty()) {
            int minDist = pq.peek().cost;
            int minIdx = pq.peek().node;
            pq.poll();
            
            if(minDist != distance[minIdx]) continue;

            for(Node node : graph[minIdx]) {
                int targetIdx = node.index;
                int targetDist = node.cost;

                int newDist = distance[minIdx] + targetDist;
                if(distance[targetIdx] > newDist) {
                    distance[targetIdx] = newDist;
                    pq.offer(new Element(targetIdx, newDist));
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