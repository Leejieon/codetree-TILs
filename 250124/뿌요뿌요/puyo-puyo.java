import java.util.*;
import java.io.*;

public class Main {

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int N, size;
    static int[][] graph;
    static boolean[][] visitied;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        visitied = new boolean[N][N];
        int maxSize = 0;
        int count = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(!visitied[y][x]) {
                    visitied[y][x] = true;
                    size = 1;
                    dfs(y, x, graph[y][x]);
                    
                    maxSize = Math.max(maxSize, size);
                    if(size >= 4) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count + " " + maxSize);
	}

    static void dfs(int y, int x, int num) {
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(isOutOfBound(ny, nx)) continue;
            if(visitied[ny][nx]) continue;
            if(graph[ny][nx] != num) continue;

            visitied[ny][nx] = true;
            size++;
            dfs(ny, nx, num);
        }
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }
}