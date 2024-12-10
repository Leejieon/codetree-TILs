import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            map.put(numbers[i], map.get(numbers[i]) - 1);

            for(int j = 0; j < i; j++) {
                if(map.containsKey(K - numbers[i] - numbers[j])) {
                    ans += map.get(K - numbers[i] - numbers[j]);
                }
            }
        }

        System.out.println(ans);
    }
}