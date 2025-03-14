import java.util.*;

public class Main {

    static int N, M;
    static long[] pipes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        pipes = new long[M];
        long max = 0;
        for (int i = 0; i < M; i++) {
            pipes[i] = sc.nextLong();
            max = Math.max(max, pipes[i]);
        }
            
        long left = 1L;
        long right = 10_000_000_000L;
        long ans = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(long time) {
        long count = 0;
        for(long pipe : pipes) {
            count += time / pipe;
        }

        return count >= N;
    }
}