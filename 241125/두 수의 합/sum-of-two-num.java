import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
            
            for(int j = 0; j < i; j++) {
                map.put(list.get(j) + number, 
                map.getOrDefault(list.get(j) + number, 0) + 1);
            }
        }

        System.out.println(map.get(K));
    }
}