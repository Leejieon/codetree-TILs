import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int rst = -1;
        for(String key : map.keySet()) {
            rst = Math.max(rst, map.get(key));
        }
        System.out.println(rst);
    }
}