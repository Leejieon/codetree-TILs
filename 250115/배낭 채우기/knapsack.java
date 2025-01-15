import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // [][0] : 무게, [][1] : 가치
        int[][] bag = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            for(int w = 1; w <= M; w++) {
                if(w >= bag[i][0]) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - bag[i][0]] + bag[i][1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[N][M]);
	}
}