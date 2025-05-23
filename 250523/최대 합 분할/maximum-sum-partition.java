import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int OFFSET = 100000;
    public static final int MAX_M = 100000;
    public static final int MAX_N = 100;
    
    // 변수 선언
    public static int n, m;
    public static int[] arr = new int[MAX_N + 1];
    
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1 + OFFSET];
    
    public static void initialize() {
        for(int i = 0; i <= n; i++)
            for(int j = -m; j <= m; j++)
                dp[i][j + OFFSET] = INT_MIN;
    
        dp[0][0 + OFFSET] = 0;
    }
    
    public static void update(int i, int j, int prevI, int prevJ, int val) {
        // 불가능한 경우 패스합니다.
        if(prevJ < -m || prevJ > m || dp[prevI][prevJ + OFFSET] == INT_MIN)
            return;
        
        dp[i][j + OFFSET] = Math.max(dp[i][j + OFFSET], dp[prevI][prevJ + OFFSET] + val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 1; i <= n; i++)
            m += arr[i];
        
        initialize();

        for(int i = 1; i <= n; i++) {
            for(int j = -m; j <= m; j++) {
                update(i, j, i - 1, j - arr[i], arr[i]);
                update(i, j, i - 1, j + arr[i], 0);
                update(i, j, i  - 1, j, 0);
            }
        }

        System.out.print(dp[n][0 + OFFSET]);
    }
}
