import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] edges;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        visited[1] = true;
        travelsal(1);

        for(int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void travelsal(int x) {
        for(int y : edges[x]) {
            if(!visited[y]) {
                visited[y] = true;
                parents[y] = x;
                travelsal(y);
            }
        }
    }
}