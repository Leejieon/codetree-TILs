import java.util.*;
import java.io.*;

public class Main {

    static int N, M, total;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            total += times[i];
        }

        System.out.println(parametricSearch());
    }

    static int parametricSearch() {
        int left = 1;
        int right = total;
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
        return ans;
    }
    
    static boolean isPossible(int x) {
        int lane = 1;
        int sum = 0;
        for(int time : times) {
            if(sum + time > x) {
                sum = 0;
                lane++;
            }
            sum += time;
        }
        return lane <= M;
    }
}