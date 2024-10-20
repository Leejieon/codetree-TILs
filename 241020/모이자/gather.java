import java.util.*;

public class Main {

    static int n;
    static int[] arr; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = getSum(i);

            if(sum < result) {
                result = sum;
            }
        }

        System.out.println(result);
    }

    static int getSum(int index) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i] * Math.abs(i - index);
        }
        return sum;
    }
}