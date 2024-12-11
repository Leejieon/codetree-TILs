import java.util.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        TreeMap<String, Double> map = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            String key = sc.next();

            map.put(key, map.getOrDefault(key, 0.0) + 1.0);
        }

        Iterator<Entry<String, Double>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Entry<String, Double> entry = iter.next();

            System.out.println(entry.getKey() + " " + String.format("%.4f", entry.getValue() * 100 / N));
        }
    }
}