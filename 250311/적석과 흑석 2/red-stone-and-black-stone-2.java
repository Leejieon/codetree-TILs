import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        TreeSet<Integer> reds = new TreeSet<>();
        for(int i = 0; i < C; i++) {
            reds.add(Integer.parseInt(br.readLine()));
        }
        
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

        int ans = 0;
        for(int i = 0; i < N; i++) {
            int a = blacks.get(i).a;
            int b = blacks.get(i).b;

            if(reds.ceiling(a) != null) {
                int ti = reds.ceiling(a);
                if(ti <= b) {
                    ans++;
                    reds.remove(ti);
                }
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