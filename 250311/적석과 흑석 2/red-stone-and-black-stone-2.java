import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] reds = new int[C];
        for(int i = 0; i < C; i++) {
            reds[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(reds);
        
        ArrayList<Black> blacks = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

           blacks.add(new Black(a, b));
        }
        Collections.sort(blacks, (o1, o2) -> {
            if(o1.b == o2.b) return o1.a - o2.a;
            return o1.b - o2.b;
        });

        int redIdx = C - 1;
        int blackIdx = N - 1;
        int ans = 0;
        while(redIdx >= 0 && blackIdx >= 0) {
            int t = reds[redIdx];
            int a = blacks.get(blackIdx).a;
            int b = blacks.get(blackIdx).b;

            if(a <= t && t <= b) {
                ans++;
                redIdx--;
                blackIdx--;
                continue;
            }
            if(a > t) {
                blackIdx--;
                continue;
            }
            if(t > b) {
                redIdx--;
                continue;
            }
        }
        System.out.println(ans);
    }

    static class Black {
        int a, b;

        Black(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}