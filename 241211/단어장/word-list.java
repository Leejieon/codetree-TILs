import java.util.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            String word = sc.next();

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Entry<String, Integer> entry = iter.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}