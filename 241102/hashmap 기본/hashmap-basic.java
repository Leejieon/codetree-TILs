import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String command = sc.next();
            
            int key = 0;
            int value = 0;
            switch(command) {
                case "add":
                    key = sc.nextInt();
                    value = sc.nextInt();
                    map.put(key, value);
                    break;
                case "find":
                    key = sc.nextInt();
                    if(map.containsKey(key)) {
                        System.out.println(map.get(key));
                    } else {
                        System.out.println("None");
                    }
                    break;
                default:
                    key = sc.nextInt();
                    map.remove(key);
                    break;
            }
        }
    }
}