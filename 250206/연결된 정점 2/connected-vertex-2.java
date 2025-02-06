import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] parents, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parents = new int[100_001];
        for(int i = 1; i <= 100_000; i++) {
            parents[i] = i;
        }

        count = new int[100_001];
        Arrays.fill(count, 1);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);

            int root = find(a);
            sb.append(count[root]).append("\n");
        }
        System.out.print(sb);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parents[y] = x;
        count[x] += count[y];
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}