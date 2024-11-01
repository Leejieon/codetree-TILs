import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long left = 1;
        long right = 2_000_000_000;
        long rst = 2_000_000_000;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(count(mid) >= n) {
                right = mid - 1;
                rst = Math.min(rst, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.println(rst);
    }

    static long count(long number) {
        return number - (number/3 + number/5 - number/15);
    }
}