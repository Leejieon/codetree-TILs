import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] edges = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        int[] indeg = new int[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            indeg[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;        
        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i = 0; i < edges[cur].size(); i++) {
                int next = edges[cur].get(i);

                indeg[next]--;

                if(indeg[next] == 0) {
                    queue.add(next);
                    count++;
                }
            }
        }

        System.out.println(count == N ? "Consistent" : "Inconsistent");

    }
}