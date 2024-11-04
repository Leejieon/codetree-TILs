import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> stringToInteger = new HashMap<>();
        HashMap<Integer, String> integerToString = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String str = sc.next();
            stringToInteger.put(str, i);
            integerToString.put(i, str);
        }

        for(int i = 0; i < m; i++) {
            String str = sc.next();
            if('0' < str.charAt(0) && str.charAt(0) <= '9') {
                System.out.println(integerToString.get(Integer.parseInt(str)));
            } else {
                System.out.println(stringToInteger.get(str));
            }
        }
    }
}