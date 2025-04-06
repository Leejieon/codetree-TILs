import java.util.*;
import java.io.*;

public class Main {

    static int N, T;
    static int[][] belts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        belts = new int[2][N];
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++) {
            belts[0][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int j = N - 1; j >= 0; j--) {
            belts[1][j] = Integer.parseInt(st.nextToken());
        }

        for(int t = 0; t < T; t++) {
            moveOneTime();
        }

        for(int i = 0; i < N; i++) {
            System.out.print(belts[0][i] + " ");
        }
        System.out.println();
        for(int i = N - 1; i >= 0; i--) {
            System.out.print(belts[1][i] + " ");
        }
    }

    static void moveOneTime() {
        // Top
        int temp = belts[0][N - 1];
        for(int i = N - 1; i > 0; i--) {
            belts[0][i] = belts[0][i - 1];
        }
        belts[0][0] = belts[1][0];

        // Bottom
        for(int i = 0; i < N - 1; i++) {
            belts[1][i] = belts[1][i + 1];
        }
        belts[1][N - 1] = temp;
    }
}