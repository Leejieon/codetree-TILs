import java.util.*;

public class Main {
    
    static int N, ans;
    static int[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        ans = 0;
        order = new int[N];
        permutation(0);

        System.out.println(ans);
    }

    static void permutation(int depth) {
        // Base Case
        if(depth == N) {
            if(isValid()) ans++;
            return;
        }

        // Recursive Case
        for(int cand = 1; cand <= 4; cand++) {
            order[depth] = cand;
            permutation(depth + 1);
        }
    }

    static boolean isValid() {
        int prev = order[0];
        int count = 1;
        for(int i = 1; i < order.length; i++) {
            if(prev == order[i]) {
                count++;
                prev = order[i];
                continue;
            }

            if(count % prev != 0) {
                return false;
            }

            count = 1;
            prev = order[i];
        }
        
        if(count % prev != 0) {
            return false;
        }
        return true;
    }
}