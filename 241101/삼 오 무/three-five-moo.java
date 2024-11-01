import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int left = 0;
        int right = 1_000_000_000;
        int rst = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(count(mid) == n) {
                rst = mid;
                break;
            }

            if(count(mid) > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(rst);
    }

    static int count(int number) {
        return number - (number/3 + number/5 - number/15);
    }
}