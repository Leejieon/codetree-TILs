import java.util.*;
import java.io.*;

public class Main {

    static final int INT_MAX = 101;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[M + 1];
        Arrays.fill(dp, INT_MAX);
        dp[0] = 0;
        for(int i = 0; i < N; i++) {
            for(int j = M; j > 0; j--) {
                if(j >= numbers[i]) {
                    if(dp[j - numbers[i]] == INT_MAX) continue;
                    dp[j] = Math.min(dp[j], dp[j - numbers[i]] + 1);
                }
            }
        }
        
        System.out.println(dp[M] == INT_MAX ? "No" : "Yes");
	}
}