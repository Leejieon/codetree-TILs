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
        boolean[][] newGraph = new boolean[N][N];

        for(int i = 0; i < order.length; i++) {
            int[] point = bomblist.get(i);
            newGraph[point[0]][point[1]] = true;

            for(int j = 0; j < 4; j++) {
                int ny = point[0] + bombs[order[i]][j][0];
                int nx = point[1] + bombs[order[i]][j][1];

                if(isOutOfBound(ny, nx)) continue;

                newGraph[ny][nx] = true;
            }
        }

        for(boolean[] rows : newGraph) {
            for(boolean point : rows) {
                if(point) {
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