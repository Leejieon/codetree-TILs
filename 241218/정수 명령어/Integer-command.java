import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            TreeSet<Integer> set = new TreeSet<>();
            
            int k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int x = Integer.parseInt(st.nextToken());

                switch(command) {
                    case "I":
                        set.add(x);
                        break;
                    case "D":
                        if(!set.isEmpty()) {
                            if(x == -1) {
                                set.remove(set.first());
                            } else {
                                set.remove(set.last());
                            }
                        }
                        break;
                }
            }
            if(set.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(set.last()).append(" ").append(set.first());
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}