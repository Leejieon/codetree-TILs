import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Long> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        long[] start = new long[m];
        long[] end = new long[m];
        for (int i = 0; i < m; i++) {
            start[i] = sc.nextLong();
            end[i] = sc.nextLong();

            for(long j = start[i]; j <= end[i]; j++) {
                list.add(j);
            }
        }
        Collections.sort(list);
        
        long left = 0;
        long right = (long)1e18;
        long ans = 0;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(long dist) {
        int count = 1;
        int prev = 0;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) - list.get(prev) < dist) continue;

            count++;
            prev = i;
        }
        return count >= n;
    }
}