import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Line> lines = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(lines, (o1, o2) -> o1.end - o2.end);

        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(lines.get(j).end < lines.get(i).start) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int rst = -1;
        for(int i = 0 ; i < N; i++) {
            rst = Math.max(rst, dp[i]);
        }
        System.out.println(rst);
    }

    static class Line {
        int start, end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}