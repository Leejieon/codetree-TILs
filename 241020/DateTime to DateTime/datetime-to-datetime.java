import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int standard = 11 * 24 * 60 + 11 * 60 + 11;
        int cur = a * 24 * 60 + b * 60 + c;

        System.out.println(cur - standard < 0 ? -1 : cur - standard);
    }
}