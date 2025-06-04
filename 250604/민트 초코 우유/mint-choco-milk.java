import java.util.*;
import java.io.*;

public class Main {

    final static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int N, T;
    static String[][] fmap;
    static int[][] bmap;
    static boolean[][] shield;
    static boolean[][] visited;
    static ArrayList<Group> groupList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        fmap = new String[N][N];
        for(int y = 0; y < N; y++) {
            String row = br.readLine();
            for(int x = 0; x < N; x++) {
                fmap[y] = row.split("");
            }
        }

        bmap = new int[N][N];
        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                bmap[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        while(T-- > 0) {
            breakfast();
            lunch();
            dinner();
            printB();
        }

        System.out.print(sb);
    }

    static void breakfast() {
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                bmap[y][x]++;
            }
        }
    }

    static void lunch() {
        // 그룹 생성
        groupList = new ArrayList<>();
        visited = new boolean[N][N];
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(!visited[y][x]) {
                    makeGroup(y, x);
                }
            }
        }

        // 신앙심 전달
        // 1. 모든 신앙심 -1
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                bmap[y][x]--;
            }
        }
        // 2. 대표자에게 신앙심 전달
        for(Group g : groupList) {
            int[] boss = g.boss;
            bmap[boss[0]][boss[1]] += g.cnt;
        }
    }

    static void makeGroup(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x});
        visited[y][x] = true;
        
        Group group = new Group(fmap[y][x], 1, new int[]{y, x});

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int d = 0; d < 4; d++) {
                int ny = point[0] + dir[d][0];
                int nx = point[1] + dir[d][1];

                if(isOutOfBound(ny, nx)) continue;
                if(visited[ny][nx]) continue;
                if(!fmap[y][x].equals(fmap[ny][nx])) continue;

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});

                // 대표자 정하기
                if(bmap[group.boss[0]][group.boss[1]] == bmap[ny][nx]) {
                    if(group.boss[0] == ny) {
                        if(group.boss[1] > nx) {
                            group.boss = new int[]{ny, nx};
                        }
                    } else if(group.boss[0] > ny) {
                        group.boss = new int[]{ny, nx};
                    }
                } else if(bmap[group.boss[0]][group.boss[1]] < bmap[ny][nx]) {
                    group.boss = new int[]{ny, nx};
                }

                // 그룹 수 증가
                group.cnt++;
            }
        }
    
        groupList.add(group);
    }

    static void dinner() {
        // 그룹 정렬
        Collections.sort(groupList, (o1, o2) -> {
            if(o1.F.length() == o2.F.length()) {
                if(bmap[o1.boss[0]][o1.boss[1]] == bmap[o2.boss[0]][o2.boss[1]]) {
                    if(o1.boss[0] == o2.boss[0]) {
                        return o1.boss[1] - o2.boss[1];
                    }
                    return o1.boss[0] - o2.boss[0];
                }
                return bmap[o2.boss[0]][o2.boss[1]] - bmap[o1.boss[0]][o1.boss[1]];
            }
            return o1.F.length() - o2.F.length();
        });

        // 전파
        shield = new boolean[N][N];
        for(Group group : groupList) {
            int[] boss = group.boss;

            if(shield[boss[0]][boss[1]]) continue; // 방어상태인 경우

            int x = bmap[boss[0]][boss[1]] - 1; // 간절함
            int d = bmap[boss[0]][boss[1]] % 4; // 전파 방향
            bmap[boss[0]][boss[1]] = 1;

            int ny = boss[0];
            int nx = boss[1];
            while(true) {
                ny += dir[d][0];
                nx += dir[d][1];

                // Base Case
                // 1. 격자 밖으로 나가는 경우
                if(isOutOfBound(ny, nx)) break;
                // 2. 간절함이 0이 되는 경우
                if(x <= 0) break;

                // 완전히 같은 경우, 전파하지 않고 다음으로 진행
                if(fmap[boss[0]][boss[1]].equals(fmap[ny][nx])) continue;

                int y = bmap[ny][nx];
                // 강한 전파
                if(x > y) {
                    fmap[ny][nx] = fmap[boss[0]][boss[1]];
                    x -= (y + 1);
                    bmap[ny][nx]++;
                    shield[ny][nx] = true;              
                } 
                // 약한 전파
                else {
                    fmap[ny][nx] = union(fmap[boss[0]][boss[1]], fmap[ny][nx]);
                    bmap[ny][nx] += x;
                    x = 0;
                    shield[ny][nx] = true;
                }
            }
        }
    }

    static String union(String str1, String str2) {
        Set<String> set = new TreeSet<>();

        String[] str = str1.split("");
        for(String s : str) {
            set.add(s);
        }

        str = str2.split("");
        for(String s : str) {
            set.add(s);
        }

        String result = "";
        for(String s : set) {
            result += s;
        }
        return result;
    }

    static boolean isOutOfBound(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    static void printB() {
        int[] list = new int[7];

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                
                switch(fmap[y][x]) {
                    case "CMT":
                        list[0] += bmap[y][x];
                        break;
                    case "CT":
                        list[1] += bmap[y][x];
                        break;
                    case "MT":
                        list[2] += bmap[y][x];
                        break;
                    case "CM":
                        list[3] += bmap[y][x];
                        break;
                    case "M":
                        list[4] += bmap[y][x];
                        break;
                    case "C":
                        list[5] += bmap[y][x];
                        break;
                    case "T":
                        list[6] += bmap[y][x];
                        break;
                }
            }
        }

        for(int i = 0; i < 7; i++) {
            sb.append(list[i]).append(" ");
        }
        sb.append("\n");
    }

    static class Group {
        String F;
        int cnt;
        int[] boss;

        Group(String F, int cnt, int[] boss) {
            this.F = F;
            this.cnt = cnt;
            this.boss = boss;
        }
    }
}