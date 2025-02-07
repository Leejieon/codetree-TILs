import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(from, to, cost));
        }

        int count = 0;
        int sum = 0;
        while(!pq.isEmpty()) {
            if(count >= N - 1) break;

            Edge edge = pq.poll();

            int node1 = edge.from;
            int node2 = edge.to;
            int cost = edge.cost;

            if(find(node1) != find(node2)) {
                union(node1, node2);
                count++;
                sum += cost;
            }
        }
        System.out.println(sum);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parents[y] = x;
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}