import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N1 = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < N1; i++) {
            set.add(sc.nextInt());
        }

        int N2 = sc.nextInt();
        for(int i = 0; i < N2; i++) {
            int number = sc.nextInt();
            System.out.print((set.contains(number) ? 1 : 0) + " ");
        }
    }
}