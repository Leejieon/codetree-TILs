import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int result = 0;
        for(int i = 0; i < str.length(); i++) {
            char first = str.charAt(i);
            if(first != '(') continue;

            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(j) == ')') {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}