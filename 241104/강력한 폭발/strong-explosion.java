import java.util.*;
import java.io.*;

public class Main {

    static int N, ans;
    static int[][] graph;
    static int[] order;
    static ArrayList<int[]> bomblist = new ArrayList<>();

    static int[][][] bombs = {
        {{-2, 0}, {-1, 0}, {1, 0}, {2, 0}},
        {{-1, 0}, {0, -1}, {0, 1}, {1, 0}},
        {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        graph = new int[N][N];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());

                if(graph[y][x] == 1) {
                    bomblist.add(new int[]{y, x});
                }
            }
        }

        ans = 0;
        order = new int[bomblist.size()];
        permutation(0);

        System.out.println(ans);
    }

    static void permutation(int depth) {
        // Base Case
        if(depth == bomblist.size()) {
            int count = getBombCount();
            ans = Math.max(ans, count);
            return;
        }

        // Recursive Case
        for(int cand = 0; cand < 3; cand++) {
            order[depth] = cand;
            permutation(depth + 1);
        }
    }

    static int getBombCount() {
        int rst = 0;
        int[][] newGraph = new int[N][N];
        for(int i = 0; i < N; i++) {
            newGraph[i] = graph[i].clone();
        }

        for(int i = 0; i < order.length; i++) {
            int[] point = bomblist.get(i);

            for(int j = 0; j < 4; j++) {
                int ny = point[0] + bombs[order[i]][j][0];
                int nx = point[1] + bombs[order[i]][j][1];

                if(isOutOfBound(ny, nx)) continue;
                if(newGraph[ny][nx] == 1) continue;

                newGraph[ny][nx] = 2;
            }
        }

        for(int[] rows : newGraph) {
            for(int point : rows) {
                if(point == 2 || point == 1) {
                    rst++;
                }
            }
        }
        return rst;
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }
}