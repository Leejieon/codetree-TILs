import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static String[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new String[N];
        for(int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        
        B = new String[N];
        for(int i = 0; i < N; i++) {
            B[i] = br.readLine();
        }

        int ans = 0;
        for(int i = 0; i < M - 2; i++) {
            for(int j = i + 1; j < M - 1; j++) {
                for(int k = j + 1; k < M; k++) {
                    if(isPossible(i, j, k)) ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean isPossible(int m1, int m2, int m3) {
        HashSet<String> aSet = new HashSet<>();
        for(int i = 0; i < N; i++) {
            aSet.add("" + A[i].charAt(m1) + A[i].charAt(m2) + A[i].charAt(m3));
        }

        for(int i = 0; i < N; i++) {
            String subStr = "" + B[i].charAt(m1) + B[i].charAt(m2) + B[i].charAt(m3);
            if(aSet.contains(subStr)) {
                return false;
            }
        }
        return true;
    }
}