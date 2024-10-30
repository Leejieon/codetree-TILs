import java.util.*;
import java.io.*;

public class Main {

    static int n, m, max;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, numbers[i]);
        }

        int left = 1;
        int right = max;
        int idx = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(getCount(mid) >= m) {
                left = mid + 1;
                idx = Math.max(idx, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(idx);
    }

    static int getCount(int standard) {
        int result = 0;
        for(int number : numbers) {
            result += number / standard;
        }
        return result;
    }
}