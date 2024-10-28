import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();

        long left = 1;
        long right = 2000000000;
        long maxIdx = 0;

        while(left <= right) {
            long mid = (left + right) / 2L;

            if((1 + mid) * mid / 2L > s) {
                right = mid - 1L;
            } else {
                left = mid + 1L;
                maxIdx = Math.max(maxIdx, mid);
            }
        }

        System.out.println(maxIdx);
    }
}