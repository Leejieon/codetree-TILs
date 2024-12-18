import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        TreeSet<Integer> set = new TreeSet<>();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            switch(command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                    break;
                case "find":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(x) ? "true" : "false").append("\n");
                    break;
                case "lower_bound":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(set.ceiling(x) != null ? set.ceiling(x) : "None").append("\n");
                    break;
                case "upper_bound":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(set.higher(x) != null ? set.higher(x) : "None").append("\n");
                    break;
                case "largest":
                    if(set.isEmpty()) {
                        sb.append("None");
                    } else {
                        sb.append(set.last());
                    }
                    sb.append("\n");
                    break;
                case "smallest":
                    if(set.isEmpty()) {
                        sb.append("None");
                    } else {
                        sb.append(set.first());
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}