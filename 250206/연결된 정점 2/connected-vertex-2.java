import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] parents, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parents = new int[100_001];
        size = new int[100_001];
        for(int i = 1; i <= 100_000; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(find(a) != find(b))
                union(a, b);

            sb.append(size[find(a)]).append("\n");
        }
        System.out.print(sb);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parents[y] = x;
        size[x] += size[y];
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}