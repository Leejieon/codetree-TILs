import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] children;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        children = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) {
                children[parent].add(i);
            }
        }

        Integer deleteNode = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            if(children[i].contains(deleteNode)) {
                children[i].remove(deleteNode);
                break;
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(!children[deleteNode].contains(i) && children[i].size() == 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}