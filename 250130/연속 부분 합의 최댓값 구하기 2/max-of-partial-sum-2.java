import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int rst = -1001;
        for(int i = 0; i < N; i++) {
            if(sum < 0) {
                sum = 0;
            }
            sum += numbers[i];
            rst = Math.max(rst, sum);
        }
        System.out.println(rst);
    }
}