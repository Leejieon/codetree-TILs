import java.util.*;
import java.io.*;

public class Main {

    static int[][] types = {
        {0, 0},
        {0, 1},
        {1, 0},
        {1, 1}
    };
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for(int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < m; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;
        for(int t = 0; t < 4; t++) {
            for(int y = 0; y <= n - 2; y++) {
                for(int x = 0; x <= m - 2; x++) {
                    int sum = getSum1(y, x, t);
                    result = Math.max(result, sum);
                }
            }
        }

        for(int y = 0; y < n; y++) {
            for(int x = 0; x <= m - 3; x++) {
                int sum = getSum2(y, x);
                result = Math.max(result, sum);
            }
        }
        
        for(int y = 0; y <= n - 3; y++) {
            for(int x = 0; x < m; x++) {
                int sum = getSum3(y, x);
                result = Math.max(result, sum);
            }
        }
        
        System.out.println(result);
    }

    static int getSum1(int y, int x, int t) {
        int result = 0;
        for(int i = y; i < y + 2; i++) {
            for(int j = x; j < x + 2; j++) {
                if(types[t][0] == i - y && types[t][1] == j - x) continue;
                result += graph[i][j];
            }
        }
        return result;
    }

    static int getSum2(int y, int x) {
        int result = 0;
        for(int j = x; j < x + 3; j++) {
            result += graph[y][j];
        }
        return result;
    }

    static int getSum3(int y, int x) {
        int result = 0;
        for(int j = y; j < y + 3; j++) {
            result += graph[j][x];
        }
        return result;
    }
}