import java.util.*;
import java.io.*;

public class Main {
	static final int LUDOLPH = 100;

	static int N, M, P, C, D;

	// 산타는 0 ~ 3번째까찌.
	static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
	static int[] dx = {0, 1, 0, -1, -1, 1, -1, 1};

	static class Santa {
		int index;
		int y, x;
		int score;
		int stun;
		boolean end;

		public Santa(int index, int y, int x) {
			this.index = index;
			this.y = y;
			this.x = x;
			this.score = 0;
			stun = 0;
			end = false;
		}
	}

	static class Board {
		public int[][] a;
		public int[] ludolph;
		public HashMap<Integer, Santa> santas;

		public Board(int n) {
			a = new int[n + 1][n + 1];
			ludolph = new int[2];
			santas = new HashMap<>();
		}

		public void moveLudolph() {
			// 0. 산타 r과 c 기준으로 내림차순 정렬
			PriorityQueue<Santa> pq = new PriorityQueue<>((o1, o2) -> {
				if(o1.y == o2.y) {
					return o2.x - o1.x;
				}
				return o2.y -o1.y;
			});
			for(int i = 1; i <= P; i++) {
				pq.offer(santas.get(i));
			}

			// 1. 가장 가까운 산타 찾기
			Santa closestSanta = null;
			int distance = Integer.MAX_VALUE;
			while(!pq.isEmpty()) {
				Santa santa = pq.poll();

				// 탈락한 산타인 경우 pass
				if(santa.end) continue;

				int cal = getDistance(ludolph[0], ludolph[1], santa.y, santa.x);
				if(distance > cal) {
					closestSanta = santa;
					distance = cal;
				}
			}

			// 2. 루돌프 이동
			distance = Integer.MAX_VALUE;
			int dir = -1;
			int ly = 0;
			int lx = 0;
			for(int k = 0; k < 8; k++) {
				int ny = ludolph[0] + dy[k];
				int nx = ludolph[1] + dx[k];

				if(isOutOfBound(ny, nx)) continue;

				int cal = getDistance(ny, nx, closestSanta.y, closestSanta.x);
				if(distance > cal) {
					ly = ny;
					lx = nx;
					distance = cal;
					dir = k;
				}
			}

			// 3. 충돌 여부 확인
			if(a[ly][lx] == 0) {
				a[ludolph[0]][ludolph[1]] = 0;
				ludolph[0] = ly;
				ludolph[1] = lx;
				a[ly][lx] = LUDOLPH;
				return;
			}

			int y = ly;
			int x = lx;
			Santa santa = null;
			if(a[y][x] != 0) {
				// 부딪힌 산타
				santa = santas.get(a[y][x]);

				santa.stun += 2;
				santa.score += C; // 점수 획득
				santa.y += dy[dir] * C;
				santa.x += dx[dir] * C; // 밀려나기

				y = santa.y;
				x = santa.x;
			}
			a[ludolph[0]][ludolph[1]] = 0;
			ludolph[0] = ly;
			ludolph[1] = lx;
			a[ly][lx] = LUDOLPH;

			// 4. 상호작용 확인
			while(true) {
				// 범위를 벗어난 경우
				if(isOutOfBound(y, x)) {
					santa.end = true;
					break;
				}

				// 도착 지점에 아무도 없는 경우, 종료
				if(a[y][x] == 0) {
					a[y][x] = santa.index;
					break;
				}

				// 부딪힌 산타
				santa = santas.get(a[y][x]);
				santa.y += dy[dir];
				santa.x += dx[dir]; // 1칸 밀려나기

				y = santa.y;
				x = santa.x;
			}
		}

		public void moveSanta(int index) {
			Santa santa = santas.get(index);

			// 0. 탈락하거나 스턴인 경우, 움직일 수 없다.
			if(santa.end) return;
			if(santa.stun > 0) return;

			// 1. 루돌프와 거리가 가까워지는 방향으로 1칸 이동
			int curDis = getDistance(ludolph[0], ludolph[1], santa.y, santa.x); // 현재 산타와 루돌프의 거리
			int distance = Integer.MAX_VALUE;
			int dir = -1;
			int y = santa.y;
			int x = santa.x;
			for(int k = 0; k < 4; k++) {
				int ny = santa.y + dy[k];
				int nx = santa.x + dx[k];
				int cal = getDistance(ludolph[0], ludolph[1], ny, nx);

				if(isOutOfBound(ny, nx)) continue;
				if(a[ny][nx] != LUDOLPH && a[ny][nx] != 0) continue;
				if(distance <= cal) continue;
				if(curDis <= cal) continue; // 이동해도 가까워지지 않는 경우

				y = ny;
				x = nx;
				distance = cal;
				dir = k;
			}
			if(dir == -1)
				return;

			// 산타가 이동했다면.
			a[santa.y][santa.x] = 0;
			santa.y = y;
			santa.x = x;

			// 2. 충돌 확인
			if(a[y][x] != LUDOLPH) {
				a[y][x] = santa.index;
				return;
			}

			santa.stun += 2;
			santa.score += D;

			// 반대 방향으로 밀려나기
			santa.y += dy[dir] * D * (-1);
			santa.x += dx[dir] * D * (-1);

			y = santa.y;
			x = santa.x;

			// 3. 상호작용 확인
			while(true) {
				// 범위를 벗어난 경우
				if(isOutOfBound(y, x)) {
					santa.end = true;
					break;
				}
				int prev = a[y][x];

				// 도착 지점에 아무도 없는 경우, 종료
				if(a[y][x] == 0) {
					a[y][x] = santa.index;
					break;
				}

				// 부딛힌 산타
				a[y][x] = santa.index;

				santa = santas.get(prev);
				santa.y += dy[dir] * (-1);
				santa.x += dx[dir] * (-1); // 1칸 밀려나기

				y = santa.y;
				x = santa.x;
			}
		}

		public boolean isEnd() {
			boolean result = true;
			for(int i = 1; i <= P; i++) {
				Santa santa = santas.get(i);
				if(!santa.end) {
					result = false;
					break;
				}
			}
			return result;
		}

		private int getDistance(int y1, int x1, int y2, int x2) {
			return (int)Math.pow(Math.abs(y1 -y2), 2) + (int)Math.pow(Math.abs(x1 - x2), 2);
		}

		private boolean isOutOfBound(int y, int x) {
			return y <= 0 || x <= 0 || y > N || x > N;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		Board board = new Board(N);

		// 루돌프 시작 위치
		st = new StringTokenizer(br.readLine());
		int ly = Integer.parseInt(st.nextToken());
		int lx = Integer.parseInt(st.nextToken());
		board.ludolph[0] = ly;
		board.ludolph[1] = lx;
		board.a[ly][lx] = LUDOLPH;

		// 산타 시작 위치
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			board.santas.put(index, new Santa(index, y, x));
			board.a[y][x] = index;
		}

		// 게임 시작
		while(M-- > 0) {
			// 0. 산타가 모두 탈락했다면, 종료
			if(board.isEnd()) break;

			// 0. 하루 뒤, 기절한 산타 1 감소
			for(int i = 1; i <= P; i++) {
				if(board.santas.get(i).stun > 0) {
					board.santas.get(i).stun--;
				}
			}

			// 1. 루돌프 이동
			board.moveLudolph();

			// 2. 산타 이동
			for(int i = 1; i <= P; i++) {
				board.moveSanta(board.santas.get(i).index);
			}

			// 3. 아직 탈락하지 않은 산타들에게 1점 부여
			for(int i = 1; i <= P; i++) {
				Santa santa = board.santas.get(i);
				if(!santa.end) {
					santa.score++;
				}
			}
		}

		// 결과 출력
		for(int i = 1; i <= P; i++) {
			System.out.print(board.santas.get(i).score + " ");
		}
	}
}