import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;
        for(int y = 0; y <= N - 3; y ++) {
            for(int x = 0; x <= N - 3; x++) {
                int sum = getSum(y, x);
                result = Math.max(result, sum);
            }
        }

        System.out.println(result);
    }

    static int getSum(int y, int x) {
        int sum = 0;
        for(int i = y; i < y + 3; i++) {
            for(int j = x; j < x + 3; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}