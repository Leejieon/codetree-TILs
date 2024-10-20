import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N - 2; x++) {
                int cnt = graph[y][x] + graph[y][x + 1] + graph[y][x + 2];
                result = Math.max(result, cnt); 
            }
        }

        System.out.println(result);
    }
}