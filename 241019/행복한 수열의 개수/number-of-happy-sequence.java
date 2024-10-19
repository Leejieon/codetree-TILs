import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int y = 0; y < n; y++) {
            int count = 1;
            int maxCount = 1;
            for(int x = 1; x < n; x++) {
                if(arr[y][x - 1] == arr[y][x]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }

            if(maxCount >= m) {
                result++;
            }
        }
        
        for(int x = 0; x < n; x++) {
            int count = 1;
            int maxCount = 1;
            for(int y = 1; y < n; y++) {
                if(arr[y - 1][x] == arr[y][x]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }

            if(maxCount >= m) {
                result++;
            }
        }

        System.out.println(result);
    }
}