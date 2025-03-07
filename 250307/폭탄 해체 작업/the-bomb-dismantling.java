import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Bomb[] bombs = new Bomb[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            bombs[i] = new Bomb(score, time);
        }
        Arrays.sort(bombs, (o1, o2) -> {
            if(o1.time == o2.time) {
                return o2.score - o1.score;
            }
            return o1.time - o2.time;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int bombIdx = N - 1;
        int ans = 0;
        for(int t = 10_000; t >= 1; t--) {
            while(bombIdx >= 0 && bombs[bombIdx].time >= t) {
                pq.add(bombs[bombIdx].score);
                bombIdx--;
            }
            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
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