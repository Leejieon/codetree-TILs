import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            list.add(new int[]{x1, x2});
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int left = 1;
        int right = 1_000_000_000;
        int ans = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean isPossible(int dist) {
        int prev = list.get(0)[0];
        for(int i = 1; i < list.size(); i++) {
            int[] point = list.get(i);

            if(prev + dist > point[1]) {
                return false;
            }
            prev = Math.max(prev + dist, point[0]);
        }

        return true;
    }
}