import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                if(pq.isEmpty()) {
                    sb.append("0");
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                pq.add(number);
            }
        }

        System.out.print(sb);
    }
}