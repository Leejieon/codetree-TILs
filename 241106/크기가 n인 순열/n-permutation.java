import java.util.*;

public class Main {

    static int N;
    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        order = new int[N];
        visited = new boolean[N + 1];
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
        for(int cand = 1; cand <= N; cand++) {
            if(!visited[cand]) {
                visited[cand] = true;
                order[depth] = cand;
                permutation(depth + 1);
                visited[cand] = false;
            }
        }
    }
}