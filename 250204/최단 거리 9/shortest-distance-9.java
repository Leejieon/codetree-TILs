import java.util.*;
import java.io.*;

public class Main {
    
    static final int INF = (int)1e9;

    static int N, M, A, B;
    static int[] distance, path;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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

            graph[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        path = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[A] = 0;

        dijkstra(A);

        sb.append(distance[B]).append("\n");
        ArrayList<Integer> rstPath = new ArrayList<>();
        int idx = B;
        while(true) {
            rstPath.add(idx);
            if(idx == A) break;
            idx = path[idx];
        }
        Collections.reverse(rstPath);

        for(int node : rstPath) {
            sb.append(node).append(" ");
        }
        System.out.println(sb);
    }

    static void dijkstra(int source) {
        PriorityQueue<Element> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.offer(new Element(source, 0));
        while(!pq.isEmpty()) {
            int minIdx = pq.peek().node;
            int minDist = pq.peek().cost;
            pq.poll();

            if(minDist != distance[minIdx]) continue;

            for(Node node : graph[minIdx]) {
                int targetIdx = node.index;
                int targetDist = node.cost;

                int newDist = distance[minIdx] + targetDist;
                if(distance[targetIdx] > newDist) {
                    distance[targetIdx] = newDist;
                    path[targetIdx] = minIdx;
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