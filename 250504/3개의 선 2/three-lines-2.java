import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static boolean isPossible;
    static int[] axis;
    static HashMap<Integer, ArrayList<Integer>> xmap = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> ymap = new HashMap<>();
    static boolean[][] checked = new boolean[11][11];
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(!xmap.containsKey(x)) {
                xmap.put(x, new ArrayList<>());
            }
            if(!ymap.containsKey(y)) {
                ymap.put(y, new ArrayList<>());
            }

            xmap.get(x).add(y);
            ymap.get(y).add(x);
            list.add(new int[]{x, y});
        }

        proceed(0, 0);
        System.out.println(isPossible ? 1 : 0);
    }

    static void proceed(int cur, int count) {
        // Base Case
        if(isPossible) {
            return;
        }
        if(count > 3) {
            if(check()) {
                isPossible = true;
            }
            return;
        }

        // Recursive Case
        for(int i = cur; i < 22; i++) {
            if(i < 11) {
                if(xmap.containsKey(i)) {
                    for(int y : xmap.get(i)) {
                        checked[i][y] = true;
                    }
                    proceed(i + 1, count + 1);
                    for(int y : xmap.get(i)) {
                        checked[i][y] = false;
                    }
                }
            } else {
                if(ymap.containsKey(i - 11)) {
                    for(int x : ymap.get(i - 11)) {
                        checked[x][i - 11] = true;
                    }
                    proceed(i + 1, count + 1);
                    for(int x : ymap.get(i - 11)) {
                        checked[x][i - 11] = false;
                    }
                }
            }
        }
    }

    static boolean check() {
        for(int[] point : list) {
            if(!checked[point[0]][point[1]]) {
                return false;
            }
        }
        return true;
    }
}