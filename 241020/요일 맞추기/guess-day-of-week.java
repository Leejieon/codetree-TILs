import java.util.*;
import java.io.*;

public class Main {

    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] daysStr = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    static String[] daysStrReverse = {"Mon", "Sun", "Sat", "Fri", "Thu", "Wed", "Tue"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int standard = getDay(m1, d1);
        int cur = getDay(m2, d2);

        if(standard < cur) {
            System.out.println(daysStr[(cur - standard)%7]);
        } else {
            System.out.println(daysStrReverse[(standard - cur)%7]);
        }
    }

    static int getDay(int m, int d) {
        int day = 0;
        for(int i = 0; i < m; i++) {
            day += days[i];
        }
        return day + d;
    }
}