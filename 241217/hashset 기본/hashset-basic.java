import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String command = sc.next();
            int number = sc.nextInt();

            switch(command) {
                case "add":
                    set.add(number);
                    break;
                case "remove":
                    set.remove(number);
                    break;
                default:
                    System.out.println(set.contains(number) ? "true" : "false");
            }
        }
    }
}