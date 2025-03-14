import java.util.*;

public class Main {

    static int N, M;
    static int[] pipes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        pipes = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            pipes[i] = sc.nextInt();
            max = Math.max(max, pipes[i]);
        }
            
        int left = 1;
        int right = N * max;
        int ans = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(int time) {
        int count = 0;
        for(int pipe : pipes) {
            count += time / pipe;
        }

        return count >= N;
    }
}