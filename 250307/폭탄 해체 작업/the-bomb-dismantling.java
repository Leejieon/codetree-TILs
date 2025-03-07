import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Bomb> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.time == o2.time) {
                return o2.score - o1.score;
            }
            return o1.time - o2.time;
        });

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            pq.offer(new Bomb(score, time));
        }

        int curTime = 0;
        int ans = 0;
        while(!pq.isEmpty()) {
            Bomb bomb = pq.poll();

            if(curTime >= bomb.time) continue;

            ans += bomb.score;
            curTime = bomb.time;
        }

        System.out.println(ans);
    }

    static class Bomb {
        int score, time;

        Bomb(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}