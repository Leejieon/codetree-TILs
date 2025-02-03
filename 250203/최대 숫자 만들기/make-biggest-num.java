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
            int div1 = (int)Math.pow(10, String.valueOf(o1).length() - 1);
            int div2 = (int)Math.pow(10, String.valueOf(o2).length() - 1);

            int num1 = 0, num2 = 0;
            while(true) {
                if(div1 == 0 && div2 == 0) break;
                
                if(div1 > 0) {
                    num1 = o1 / div1;
                    o1 %= div1;
                    div1 /= 10;
                }
                if(div2 > 0) {
                    num2 = o2 / div2;
                    o2 %= div2;
                    div2 /= 10;
                }

                if(num1 > num2) {
                    return -1;
                } else if(num1 < num2) {
                    return 1;
                }
            }
            return 0;
        });

        String number = String.valueOf(list.get(0));
        for(int i = 1; i < list.size(); i++) {
            number += list.get(i);
        }
        System.out.println(number);
    }
}