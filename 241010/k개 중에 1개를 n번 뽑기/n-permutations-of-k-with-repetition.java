import java.util.*;

public class Main {
    static int k, n;
    static int[] order, numbers;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        order = new int[n];
        numbers = new int[k];
        for(int i=0;i<k;i++) {
            numbers[i] = i + 1;
        }

        permutation(0);
    }

    static void permutation(int depth) {
        // Base case
        if(depth == n) {
            for(int i : order) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // Recursive Case
        for(int cand = 0; cand < n; cand++) {
            order[depth] = numbers[cand];
            permutation(depth + 1);
        }
    }
}