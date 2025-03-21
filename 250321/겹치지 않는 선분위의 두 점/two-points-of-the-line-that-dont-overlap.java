import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Pair> segments = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            segments.add(new Pair(a, b));
        }
        Collections.sort(segments, (o1, o2) -> {
            if (o1.a != o2.a) {
                return Long.compare(o1.a, o2.a);
            }
            return Long.compare(o1.b, o2.b);
        });
        
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
        int count = 0;
        long lastX = -(long)1e18;

        for(int i = 0; i < segments.size(); i++) {
            long a = segments.get(i).a;
            long b = segments.get(i).b;

            while(lastX + dist <= b) {
                count++;
                lastX = Math.max(a, lastX + dist);
                if(count >= n) break;
            }
        }
        return count >= n;
    }

    static class Pair {
        long a, b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    } 
}