import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1; i <= M; i++) {
            set.add(i);
        }

        st = new StringTokenizer(br.readLine());
        while(N-- > 0) {
            int ball = Integer.parseInt(st.nextToken());
            set.remove(ball);

            sb.append(set.last()).append("\n");
        }

        System.out.print(sb);
	}
}