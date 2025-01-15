import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sticks = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int s = 1; s <= N; s++) {
            for(int l = 1; l <= N; l++) {
                if(l >= s) {
                    if(dp[l - s] == -1) continue;
                    dp[l] = Math.max(dp[l], dp[l - s] + sticks[s]);
                }
            }
        }

        System.out.println(dp[N]);
	}
}