import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            System.out.println(set.contains(sc.nextInt()) ? 1 : 0);
        }
    }
}