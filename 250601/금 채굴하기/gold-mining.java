import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] graph;
    static HashSet<Point> goldSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());

                if(graph[y][x] == 1) {
                    goldSet.add(new Point(y, x));
                }
            }
        }

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                
            }
        }
    }



    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point other = (Point) obj;
            return this.y == other.y && this.x == other.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}