import java.util.*;
import java.io.*;

public class Main {
    static final int N_l = 5;
    static final int N_s = 3;

    // 고대 문자 격자
    static class Board {
        int[][] arr = new int[N_l][N_l];

        public Board() {
            for(int y = 0; y < N_l; y++) {
                for(int x = 0; x < N_l; x++) {
                    arr[y][x] = 0;
                }
            }
        }

        public Board rotate(int sy, int sx, int cnt) {
            Board result = new Board();
            for(int y = 0; y < N_l; y++) {
                for(int x = 0; x < N_l; x++) {
                    result.arr[y][x] = this.arr[y][x];
                }
            }
            for(int k = 0; k < cnt; k++) {
                // 4 꼭지점 회전
                int tmp = result.arr[sy][sx + 2];
                result.arr[sy][sx + 2] = result.arr[sy][sx];
                result.arr[sy][sx] = result.arr[sy + 2][sx];
                result.arr[sy + 2][sx] = result.arr[sy + 2][sx + 2];
                result.arr[sy + 2][sx + 2] = tmp;
                // 중앙 회전
                tmp = result.arr[sy + 1][sx + 2];
                result.arr[sy + 1][sx + 2] = result.arr[sy][sx + 1];
                result.arr[sy][sx + 1] = result.arr[sy + 1][sx];
                result.arr[sy + 1][sx] = result.arr[sy + 2][sx + 1];
                result.arr[sy + 2][sx + 1] = tmp;
            }      
            return result;
        }

        public int calScore() {
            int score = 0;
            boolean[][] visited = new boolean[N_l][N_l];
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            for(int i = 0; i < N_l; i++) {
                for(int j = 0; j < N_l; j++) {
                    if(!visited[i][j]) {
                        Queue<int[]> q = new LinkedList<>();
                        Queue<int[]> trace = new LinkedList<>();

                        q.offer(new int[]{i, j});
                        trace.offer(new int[]{i, j});
                        visited[i][j] = true;
                        while(!q.isEmpty()) {
                            int[] cur = q.poll();
                            for(int k = 0; k < 4; k++) {
                                int ny = cur[0] + dy[k];
                                int nx = cur[1] + dx[k];
                                
                                if(isOutOfBound(ny, nx)) continue;
                                if(visited[ny][nx]) continue;
                                if(arr[cur[0]][cur[1]] != arr[ny][nx]) continue;

                                q.offer(new int[]{ny, nx});
                                trace.offer(new int[]{ny, nx});
                                visited[ny][nx] = true;
                            }
                        }

                        if(trace.size() >= 3) {
                            score += trace.size();
                            while(!trace.isEmpty()) {
                                int[] t = trace.poll();
                                arr[t[0]][t[1]] = 0;
                            }
                        }
                    }
                }
            }
            return score;
        }

        public void fill(Queue<Integer> que) {
            for(int j = 0; j < N_l; j++) {
                for(int i = N_l - 1; i >= 0; i--) {
                    if(arr[i][j] == 0 && !que.isEmpty()) {
                        arr[i][j] = que.poll();
                    }
                }
            }
        }

        private boolean isOutOfBound(int y, int x) {
            return y < 0 || x < 0 || y >= N_l || x >= N_l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        Board board = new Board();

        for(int y = 0; y < N_l; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N_l; x++) {
                board.arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        while(K-- > 0) {
            int maxScore = 0;
            Board maxScoreBoard = null;

            // 1. 유물 가치 최대
            // 2. 회전 각도 제일 적게
            // 3. 좌표값
            for(int cnt = 1; cnt < 4; cnt++) {
                for(int sx = 0; sx <= N_l - N_s; sx++) {
                    for(int sy = 0; sy <= N_l - N_s; sy++) {
                        Board rotated = board.rotate(sy, sx, cnt);
                        int score = rotated.calScore();
                        if(maxScore < score) {
                            maxScore = score;
                            maxScoreBoard = rotated;
                        }
                    }
                }
            }

            if(maxScoreBoard == null) {
                break;
            }
            board = maxScoreBoard;

            while(true) {
                board.fill(q);
                int newScore = board.calScore();
                if(newScore == 0) break;
                maxScore += newScore;
            }

            System.out.print(maxScore + " ");
        }
    }
}