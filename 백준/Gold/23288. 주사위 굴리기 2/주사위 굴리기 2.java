import java.io.*;
import java.util.*;
 
public class Main {
	static final int[] dirX = {0, -1, 0, 1};	// 우 상 좌 하
	static final int[] dirY = {1, 0, -1, 0};
	static int N, M, K, result;
	static int dir;
	static int[][] map;
	static int[][] dice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 지도의 세로 크기 N (2 ≤ N, M ≤ 20)
		M = Integer.parseInt(st.nextToken());	// 지도의 가로 크기 M 
		K = Integer.parseInt(st.nextToken());	// 이동하는 횟수 K (1 ≤ K ≤ 1,000)
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 지도에 쓰여 있는 수 (10 미만의 자연수)
			}
		}
		
		dice = new int[4][4];
		
		dice[0][1] = 2;
		dice[1][0] = 4; dice[1][1] = 1; dice[1][2] = 3; dice[1][3] = 6;
		dice[2][1] = 5;
		dice[3][1] = 6;
		// 주사위의 전개도
		//  2
		//4 1 3 (6)
		//  5
		//  6
		
		dir = 0;	// 주사위의 이동 방뱡 (가장 처음에는 동쪽)
		moveDice(0, 0, 0);
		
		
		//각 이동에서 획득하는 점수의 합을 출력
		System.out.println(result);
		br.close();
	}

	private static void moveDice(int x, int y, int cnt) {
		if(cnt == K) {
			return;
		}
		
		// 주사위가 이동 방향으로 한 칸 굴러간다.
		int dx = x + dirX[dir];
		int dy = y + dirY[dir];
		
		if(!(0<=dx && dx<N && 0<=dy && dy<M))  {
			// 만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다.
			dir = (dir + 2) % 4;
			dx += (2 * dirX[dir]);
			dy += (2 * dirY[dir]);
		}
		
		// 주사위 값 변경
		if(dir == 0) {			// 우
			for (int i = 1; i < 4; i++) {
				dice[1][0] += dice[1][i];
				dice[1][i] = dice[1][0] - dice[1][i];
				dice[1][0] -= dice[1][i];
			}
			dice[3][1] = dice[1][3];
		} else if (dir==1) {	// 상
			for (int i = 2; i >= 0; i--) {
				dice[3][1] += dice[i][1];
				dice[i][1] = dice[3][1] - dice[i][1];
				dice[3][1] -= dice[i][1];
			}
			dice[1][3] = dice[3][1];
		} else if (dir==2) {	// 좌
			for (int i = 2; i >= 0; i--) {
				dice[1][3] += dice[1][i];
				dice[1][i] = dice[1][3] - dice[1][i];
				dice[1][3] -= dice[1][i];
			}
			dice[3][1] = dice[1][3];
		} else {				// 하
			for (int i = 1; i < 4; i++) {
				dice[0][1] += dice[i][1];
				dice[i][1] = dice[0][1] - dice[i][1];
				dice[0][1] -= dice[i][1];
			}
			dice[1][3] = dice[3][1];
		}
		
		// 이동 방향 결정
		int A = dice[1][3];	//주사위의 아랫면에 있는 정수 A
		int B = map[dx][dy];//주사위가 있는 칸 (x, y)에 있는 정수 B
		
		// A = B인 경우 이동 방향에 변화는 없다.
		if (A > B) dir = (dir + 3) % 4;			// A > B인 경우 이동 방향을 90도 시계 방향으로 회전
		else if (A < B) dir = (dir + 1) % 4;	// A < B인 경우 이동 방향을 90도 반시계 방향으로 회전
		
		// 주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
		result += getScore(dx, dy, 1);
		
		moveDice(dx, dy, cnt+1);
	}

	private static int getScore(int x, int y, int cnt) {
		boolean[][] v = new boolean[N][M];
		
		v[x][y] = true;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x, y});
		
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				// (x, y)에 있는 정수를 B라고 했을때, (x, y)에서 동서남북 방향으로
				// 연속해서 이동할 수 있는 칸의 수 C를 모두 구한다.
				// 이때 이동할 수 있는 칸에는 모두 정수 B가 있어야 한다.
				if(0<=dx && dx<N && 0<=dy && dy<M && !v[dx][dy] && map[dx][dy] == map[x][y]) {
					cnt++;
					v[dx][dy] = true;
					q.offer(new int[] {dx, dy});
				}
			}
		}
		return map[x][y] * cnt;    // 여기서 점수는 B와 C를 곱한 값이다.
	}
}