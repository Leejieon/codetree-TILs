import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Point> set = new TreeSet<>();
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Point(x, y));
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); 
            Point p = new Point(x, y);

            Point fp = set.ceiling(p);
            if(fp == null) {
                sb.append("-1 -1");
            } else {
                sb.append(fp.x).append(" ").append(fp.y);
            }
            sb.append("\n");
        }

        System.out.print(sb);

	}

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if(this.x == p.x) {
                return this.y - p.y;
            }
            return this.x - p.x;
        }
    }
}