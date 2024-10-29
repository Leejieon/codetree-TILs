import java.util.*;

public class Main {
    
    static int[] numbers;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        for(int i = 0; i < m; i++) {
            int target = sc.nextInt();

            int left = 0;
            int right = n - 1;
            int idx = -1;
            while(left <= right) {
                int mid = (left + right) / 2;

                if(numbers[mid] == target) {
                    idx = mid + 1;
                    break;
                }

                if(numbers[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(idx);
        }
    }
}