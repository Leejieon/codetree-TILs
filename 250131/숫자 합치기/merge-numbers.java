import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int cost = 0;
        while(true) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            cost += num1 + num2;

            if(pq.isEmpty()) break;

            pq.add(num1 + num2);
        }

        System.out.println(cost);
    }
}