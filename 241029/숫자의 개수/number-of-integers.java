import java.util.*;

public class Main {

    static int n, m;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        
        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            int target = sc.nextInt();

            int left = 0;
            int right = n - 1;

            int lb = lowerBound(left, right, target);
            int ub = upperBound(left, right, target);
            
            System.out.println(ub - lb);
        }
    }

    static int lowerBound(int left, int right, int target) {
        int minIdx = n;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(numbers[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }

    static int upperBound(int left, int right, int target) {
        int minIdx = n;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(numbers[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }
}