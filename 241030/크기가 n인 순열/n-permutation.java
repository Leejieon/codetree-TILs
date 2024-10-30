import java.util.*;

public class Main {
    
    static int n;
    static boolean[] visited;
    static int[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[n + 1];
        order = new int[n + 1];

        permutation(1);
    }

    static void permutation(int depth) {
        // Base Case
        if(depth == n + 1) {
            for(int i = 1; i <= n; i++) {
                System.out.print(order[i] + " ");
            }
            System.out.println();
            return;
        }

        // Recursive Case
        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            order[depth] = i;
            permutation(depth + 1);
            visited[i] = false;
        }
    }

}