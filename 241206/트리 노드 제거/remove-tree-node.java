import java.util.*;
import java.io.*;

public class Main {

    static int N, root;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }

            edges[parent].add(i);
            edges[i].add(parent);
        }

        Integer deleteNode = Integer.parseInt(br.readLine());
        for(int i : edges[deleteNode]) {
            edges[i].clear();
        }
        for(int i = 0; i < N; i++) {
            edges[i].remove(deleteNode);
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(edges[i].size() == 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}