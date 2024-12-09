import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static Set<Integer> nodes = new HashSet<>();
    static ArrayList<Integer>[] edges;
    static int[] inDeg;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        edges = new ArrayList[10_001];
        for(int i = 0; i < 10_001; i++) {
            edges[i] = new ArrayList<>();
        }

        inDeg = new int[10_001];
        visited = new boolean[10_001];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodes.add(from);
            nodes.add(to);
            inDeg[to]++;
            edges[from].add(to);
            edges[to].add(from);
        }
        
        // 1. 루트는 한 개
        // 2. 루트를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선
        boolean isTree = true;
        int rootCount = 0;
        int root = -1;

        for(int i : nodes) {
            if(inDeg[i] == 0) {
                rootCount++;
                root = i;
            }
            if(inDeg[i] != 1) {
                isTree = false;
                break;
            }
        }
        isTree = rootCount == 1 ? true : false;

        if(!isTree) {
            System.out.println(0);
            return;
        }

        travelsal(root);
        for(int i : nodes) {
            if(!visited[i]) {
                isTree = false;
                break;
            }
        }

        System.out.println(isTree ? 1 : 0);
    }

    static void travelsal(int x) {
        for(int next : edges[x]) {
            if(!visited[next]) {
                visited[next] = true;
                travelsal(next);
            }
        }
    }
}