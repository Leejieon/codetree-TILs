import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        int[] numbers = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            numbers[i] = y;
            map.put(y, x);
        }
        Arrays.sort(numbers);

        int minIdx = 0;
        int maxIdx = N - 1;
        int ans = 0;
        while(minIdx <= maxIdx) {
            int minNum = numbers[minIdx];
            int maxNum = numbers[maxIdx];

            int sum = minNum + maxNum;
            ans = Math.max(ans, sum);

            if(map.get(minNum) > map.get(maxNum)) {
                map.put(minNum, map.get(minNum) - map.get(maxNum));
                maxIdx--;
            } else if(map.get(minNum) < map.get(maxNum)) {
                map.put(maxNum, map.get(maxNum) - map.get(minNum));
                minIdx++;
            } else {
                minIdx++;
                maxIdx--;
            }
        }
        System.out.println(ans);
    }
}