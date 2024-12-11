import java.util.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 1; i <= N; i++) {
            int number = sc.nextInt();

            if(!map.containsKey(number)) {
                map.put(number, i);
            }
        }

        Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Entry<Integer, Integer> entry = iter.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}