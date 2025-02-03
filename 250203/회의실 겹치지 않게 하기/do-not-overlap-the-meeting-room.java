import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // [0] = start time;
        // [1] = end time;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }

        int count = 0;
        int lastEnd = 0;
        while(!pq.isEmpty()) {
            int[] meeting = pq.poll();

            if(meeting[0] >= lastEnd) {
                count++;
                lastEnd = meeting[1];
            }
        }

        System.out.println(N - count);
    }
}