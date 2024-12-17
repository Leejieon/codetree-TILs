import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> rstSet = new HashSet<>();
        HashSet<Integer> tmpSet = new HashSet<>(aSet);

        aSet.removeAll(bSet);
        rstSet.addAll(aSet);

        bSet.removeAll(tmpSet);
        rstSet.addAll(bSet);

        System.out.println(rstSet.size());
    }
}