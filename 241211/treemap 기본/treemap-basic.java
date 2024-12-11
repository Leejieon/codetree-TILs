import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            
            if(command.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                map.put(key, value);
            } else if(command.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                map.remove(key);
            } else if(command.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if(map.containsKey(key)) {
                    System.out.println(map.get(key));
                } else {
                    System.out.println("None");
                }
            } else {
                if(map.isEmpty()) {
                    System.out.println("None");
                } else {
                    Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
                    while(iter.hasNext()) {
                        Entry<Integer, Integer> entry = iter.next();
                        System.out.print(entry.getValue() + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}