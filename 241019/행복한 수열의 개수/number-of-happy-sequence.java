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
            int prev = arr[y][0];
            int count = 1;
            boolean check = false;
            for(int x = 1; x < n; x++) {
                if(prev == arr[y][x]) {
                    count++;
                    if(count >= m) {
                        check = true;
                    }
                } else {
                    count = 1;
                }
                prev = arr[y][x];
            }

            if(check) {
                result++;
            }
        }
        
        for(int x = 0; x < n; x++) {
            int prev = arr[0][x];
            int count = 1;
            boolean check = false;
            for(int y = 1; y < n; y++) {
                if(prev == arr[y][x]) {
                    count++;
                    if(count >= m) {
                        check = true;
                    }
                } else {
                    count = 1;
                }
                prev = arr[y][x];
            }

            if(check) {
                result++;
            }
        }

        System.out.println(result);
    }
}