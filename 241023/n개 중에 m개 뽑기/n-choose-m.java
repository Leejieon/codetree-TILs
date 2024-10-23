import java.util.*;

public class Main {
    
    static int n, m;
    static int[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        order = new int[m];
        combination(0, 0);
    }

    static void combination(int depth, int prev) {
        // Base Case
        if(depth == m) {
            for(int number : order) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        // Recursive Case
        for(int cand = prev + 1; cand <= n; cand++) {
            order[depth] = cand;
            combination(depth + 1, cand);
        }
    }
}