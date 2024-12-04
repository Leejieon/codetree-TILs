import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(map.containsKey(x)) {
                if(map.get(x) > y) {
                    map.put(x, y);
                }
            } else {
                map.put(x, y);
            }
        }
        
        int ans = 0;
        for(int key : map.keySet()) {
            ans += map.get(key);
        }

        System.out.println(ans);
    }
}