import java.util.*;

public class Main {

    static int n, answer;
    static int[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        order = new int[n];
        answer = 0;

        permutation(0);
        System.out.println(answer);
    }

    static void permutation(int depth) {
        // Base Case
        if(depth == n) {
            if(success()) answer++;
            return;
        }

        // Recursive Case
        for(int cand = 1; cand <= 4; cand++) {
            order[depth] = cand;
            permutation(depth + 1);
        }
    }

    static boolean success() {
        boolean result = false;
        int count = 1;
        int prev = order[0];
        for(int i = 1; i < n; i++) {
            if(order[i] == prev) {
                count++;
            } else {
                if(count % prev == 0) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
                count = 1;
            }
            prev = order[i];
        }

        if(count % prev == 0) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
}