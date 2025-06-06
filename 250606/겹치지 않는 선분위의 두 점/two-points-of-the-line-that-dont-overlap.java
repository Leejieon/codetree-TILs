import java.util.Scanner;
import java.util.Arrays;

class Pair implements Comparable<Pair> { 
    long a, b;
    public Pair(long a, long b) { 
        this.a = a; 
        this.b = b; 
    }
    @Override
    public int compareTo(Pair other) {
        if(a > other.a) return 1;
        if(a < other.a) return -1;

        if(b > other.b) return 1;
        return -1;
    }
}

public class Main {
    public static final long MAX_NUM = (long)1e18;
    public static final int MAX_M = 100000;
    
    public static int n, m;
    public static Pair[] segments = new Pair[MAX_M];
    
    public static boolean isPossible(long dist) {
        int cnt = 0;
        long lastX = -MAX_NUM;
        for(int i = 0; i < m; i++) {
            long a = segments[i].a;
            long b = segments[i].b;

            while(lastX + dist <= b) {
                cnt++;
                lastX = Math.max(a, lastX + dist);

                if(cnt >= n)
                    break;
            }
        }
        return cnt >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            segments[i] = new Pair(a, b);
        }

        Arrays.sort(segments, 0, m);
        
        long left = 1;                          
        long right = MAX_NUM;                   
        long ans = 0;                           
        
        while (left <= right) {
            long mid = (left + right) / 2;      
            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
            else                               
                right = mid - 1; 
        }

        System.out.print(ans);
    }
}
