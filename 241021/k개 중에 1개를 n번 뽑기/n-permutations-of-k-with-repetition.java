import java.util.*;

public class Main {

    static int k, n;
    static int[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        order = new int[n];
        permutation(0);
    }

    static void permutation(int count) {
        // Base Case
        if(count == n) {
            for(int number : order) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        // Recursive Case
        for(int cand = 1; cand <= k; cand++) {
            order[count] = cand;
            permutation(count + 1);
        }
    }
}