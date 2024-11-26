import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            for(int key : map.keySet()) {
                int sum = key + number;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        System.out.println(sumMap.getOrDefault(K, 0));
    }
}