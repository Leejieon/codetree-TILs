import java.util.*;

public class Main {
    
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fibbo(n));
    }

    static int fibbo(int number) {
        // Base Case
        if(number <= 1) {
            return dp[number];
        }

        if(dp[number] != -1) {
            return dp[number];
        }

        // Recursive Case
        dp[number] = fibbo(number - 1) + fibbo(number - 2);
        return dp[number];
    }
}