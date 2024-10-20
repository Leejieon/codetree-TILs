import java.util.*;
import java.io.*;

public class Main {

    static int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] daysStr = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int standard = getDay(m1, d1);
        int cur = getDay(m2, d2);

        int diff = cur - standard;
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("Mon", 0);
            put("Tue", 1);
            put("Wed", 2);
            put("Thu", 3);
            put("Fri", 4);
            put("Sat", 5);
            put("Sun", 6);
        }};

        int day = map.get(br.readLine());
        System.out.println((diff/7) + (diff%7 >= day ? 1 : 0));
    }

    static int getDay(int m, int d) {
        int day = 0;
        for(int i = 0; i < m; i++) {
            day += days[i];
        }
        return day + d;
    }
}