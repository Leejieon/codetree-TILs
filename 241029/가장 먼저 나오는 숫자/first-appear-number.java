import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = n;
            int left = 0;
            int right = n - 1;
            while(left <= right) {
                int mid = (left + right) / 2;

                if(numbers[mid] >= target) {
                    right = mid - 1;
                    if(numbers[mid] == target) {
                        idx = Math.min(idx, mid + 1);
                    } 
                } else {
                    left = mid + 1;
                }
            }
            if(idx == n) {
                idx = -1;
            }
            System.out.println(idx);
        }
    }
}