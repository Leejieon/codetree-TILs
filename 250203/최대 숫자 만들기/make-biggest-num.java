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
            String number1 = String.valueOf(o1) + String.valueOf(o2);
            String number2 = String.valueOf(o2) + String.valueOf(o1);

            return -number1.compareTo(number2);
        });

        String number = String.valueOf(list.get(0));
        for(int i = 1; i < list.size(); i++) {
            number += list.get(i);
        }
        System.out.println(number);
    }
}