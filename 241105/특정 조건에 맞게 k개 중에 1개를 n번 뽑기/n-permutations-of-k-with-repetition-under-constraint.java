import java.util.*;

public class Main {

    static int K, N, ans;
    static int[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        ans = 0;
        order = new int[N];
        permutation(0);
    }

    static void permutation(int depth) {
        // Base Case
        if(depth == N) {
            for(int number : order) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        // Recursive Case
        for(int i = 1; i <= K; i++) {
            if(depth >= 2 && order[depth - 2] == order[depth - 1] && order[depth - 1] == i) continue;

            order[depth] = i;
            permutation(depth + 1);
        }
    }
}