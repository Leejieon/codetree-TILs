import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] nodes = new String[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            nodes[i] = st.nextToken();
        }

        Arrays.sort(nodes, 1, N + 1);

        HashMap<String, Integer> stringToNode = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            stringToNode.put(nodes[i], i);
        }

        int M = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] edges = new ArrayList[N + 1];
        ArrayList<Integer>[] child = new ArrayList[N + 1];
        ArrayList<Integer> roots = new ArrayList<>();
        int[] indeg = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = stringToNode.get(st.nextToken());
            int y = stringToNode.get(st.nextToken());

            edges[y].add(x);
            indeg[x]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) {
                queue.add(i);
                roots.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i = 0; i < edges[cur].size(); i++) {
                int next = edges[cur].get(i);

                indeg[next]--;

                if(indeg[next] == 0) {
                    queue.add(next);
                    child[cur].add(next);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(child[i]);
        }

        // Output
        sb.append(roots.size()).append("\n");
        
        for(int i = 0; i < roots.size(); i++) {
            sb.append(nodes[roots.get(i)]).append(" ");
        }
        sb.append("\n");

        for(int i = 1; i <= N; i++) {
            sb.append(nodes[i]).append(" ");
            sb.append(child[i].size()).append(" ");
            for(int j = 0; j < child[i].size(); j++) {
                sb.append(nodes[child[i].get(j)]).append(" ");
            }
            sb.append("\n");
        }
        for(int i = 1; i <= N; i++) {
            sb.append(nodes[i]).append(" ");
            sb.append(child[i].size()).append(" ");
            for(int j = 0; j < child[i].size(); j++) {
                sb.append(nodes[child[i].get(j)]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);


테스트케이스


결과


코드 실행


제출 및 채점




        System.out.print(sb);
    }
}