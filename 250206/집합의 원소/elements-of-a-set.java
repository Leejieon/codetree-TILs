import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0) {
                union(a, b);
            } else {
                if(parents[a] == parents[b]) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parents[y] = x;
    }

    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}