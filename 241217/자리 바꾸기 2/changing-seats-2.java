import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] sets = new HashSet[N + 1];
        for(int i = 1; i <= N; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(i);
        }

        int[] seats = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            seats[i] = i;
        }

        int[][] ks = new int[K][2];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            ks[i][0] = Integer.parseInt(st.nextToken());
            ks[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < K*3; i++) {
            int index = i % K;

            int p1 = ks[index][0];
            int p2 = ks[index][1];

            sets[seats[p1]].add(p2);
            sets[seats[p2]].add(p1);

            int tmp = seats[p1];
            seats[p1] = seats[p2];
            seats[p2] = tmp;
        }

        for(int i = 1; i <= N; i++) {
            System.out.println(sets[i].size());
        }
    }
}