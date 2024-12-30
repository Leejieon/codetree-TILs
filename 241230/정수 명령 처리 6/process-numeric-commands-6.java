import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int number = 0;
            switch(command) {
                case "push":
                    number = Integer.parseInt(st.nextToken());
                    pq.add(number);
                    break;
                case "pop":
                    sb.append(pq.poll()).append("\n");
                    break;
                case "size":
                    sb.append(pq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(pq.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "top":
                    sb.append(pq.peek()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
	}
}