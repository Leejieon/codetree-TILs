import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        points = new int[N];
        for(int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = 1_000_000_000;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(int distance) {
        int count = 1;
        int cur = points[0];
        for(int i = 1; i < N; i++) {
            int next = points[i];

            if(next - cur >= distance) {
                count++;
                cur = next;
            }
        }
        return count >= M;
    }
}