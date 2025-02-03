import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, (o1, o2) -> {
            int number1 = Integer.parseInt(String.valueOf(o1) + String.valueOf(o2));
            int number2 = Integer.parseInt(String.valueOf(o2) + String.valueOf(o1));

            if(number1 > number2) {
                return -1;
            } else if(number1 < number2) {
                return 1;
            } else {
                return 0;
            }
        });

        String number = String.valueOf(list.get(0));
        for(int i = 1; i < list.size(); i++) {
            number += list.get(i);
        }
        System.out.println(number);
    }
}