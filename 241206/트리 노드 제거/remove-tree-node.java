import java.util.*;
import java.io.*;

public class Main {

    static int N, root, ans;
    static ArrayList<Integer>[] children;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        children = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }
            children[parent].add(i);
        }

        Integer deleteNode = Integer.parseInt(br.readLine());
        children[deleteNode].clear();
        for(int i = 0; i < N; i++) {
            if(children[i].contains(deleteNode)) {
                children[i].remove(deleteNode);
                break;
            }
        }
        
        ans = 0;
        visited[root] = true;
        dfs(root);
        System.out.println(ans);
    }

    static void dfs(int x) {
        if(children[x].isEmpty()) return;
        
        int count = 0;
        for(int y : children[x]) {
            if(!visited[y]) {
                count++;
                visited[y] = true;
                dfs(y);
            }
        }

        if(count == 0) {
            ans++;
        }
    }
}