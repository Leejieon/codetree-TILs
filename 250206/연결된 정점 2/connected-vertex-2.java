import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static HashMap<Integer, Integer> parents = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!parents.containsKey(a)) {
                parents.put(a, a);
            }
            if(!parents.containsKey(b)) {
                parents.put(b, b);
            }

            union(a, b);
            
            int root = find(b);
            int count = 0;
            for(int node : parents.keySet()) {
                if(parents.get(node) == root) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parents.put(y, x);
    }

    static int find(int x) {
        if(parents.get(x) == x) return x;
        parents.put(x, find(parents.get(x)));
        return parents.get(x);
    }
}