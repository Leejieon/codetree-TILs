import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Character ans = null;
        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(map.get(c) == 1) {
                ans = c;
                break;
            }
        }

        System.out.println(ans == null ? "None" : ans);
    }
}