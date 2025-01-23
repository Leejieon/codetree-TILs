import java.util.*;
import java.io.*;

public class Main {

    static int N, M, ans;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        ans = 0;
        visited = new boolean[N + 1];

        visited[1] = true;
        dfs(1);

        System.out.println(ans);
    }

    static void dfs(int v) {
        for(int next : graph[v]) {
            if(!visited[next]) {
                visited[next] = true;
                ans++;
                dfs(next);
            }
        }
    }
}