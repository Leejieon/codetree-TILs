import java.util.*;
import java.io.*;

public class Main {
    
    static long N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        K = Long.parseLong(br.readLine());

        long left = 1;
        long right = N * N;

        long ans = N * N;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(getCount(mid) >= K) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static long getCount(long number) {
        long count = 0;
        for(int i = 1; i <= N; i++) {
            count += Math.min(N, number/i);
        }
        return count;
    }
}