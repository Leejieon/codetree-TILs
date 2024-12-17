import java.util.*;
import java.io.*;

public class Main {

    static int N, G;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] groups = new HashSet[G];
        for(int i = 0; i < G; i++) {
            groups[i] = new HashSet<>();
        }

        HashSet<Integer>[] persons = new HashSet[N + 1];
        for(int i = 1; i <= N; i++) {
            persons[i] = new HashSet<>();
        }

        for(int i = 0; i < G; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for(int c = 0; c < count; c++) {
                int p = Integer.parseInt(st.nextToken());
                groups[i].add(p);
                persons[p].add(i);
            }
        }

        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        while(true) {
            ans += list.size();

            if(list.isEmpty()) break;

            for(HashSet<Integer> group : groups) {
                for(int person : list) {
                    if(group.contains(person)) {
                        group.remove(person);
                    }
                }
            }
            list.clear();
            
            for(HashSet<Integer> group : groups) {
                if(group.size() == 1) {
                    for(int p : group) {
                        list.add(p);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}