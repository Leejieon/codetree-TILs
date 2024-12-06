import java.util.*;
import java.io.*;

public class Main {

    static int N, root, ans;
    static ArrayList<Integer>[] children;
    static boolean[] isDeleted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isDeleted = new boolean[N];
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

        int deleteNode = Integer.parseInt(br.readLine());
        isDeleted[deleteNode] = true;
        
        ans = 0;
        dfs(root);
        System.out.println(ans);
    }

    static void dfs(int x) {
        if(isDeleted[x]) return;

        boolean isLeaf = true;

        for(int y : children[x]) {
            if(isDeleted[y]) continue;

            dfs(y);
            isLeaf = false;
        }

        if(isLeaf)
            ans++;
    }
}