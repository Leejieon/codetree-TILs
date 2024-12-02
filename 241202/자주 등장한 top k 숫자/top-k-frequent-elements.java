import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });
        
        for(int key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

        for(int i = 0; i < K; i++) {
            System.out.print(pq.poll()[0] + " ");
        }
    }
}