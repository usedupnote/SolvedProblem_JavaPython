import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1,1,0,0}; // 상하좌우
	static final int[] dirY = {0,0,-1,1};
	static final int INF = Integer.MAX_VALUE;
	
	static int N, X, result;
	static int[][] map;
	static boolean[][][][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//지도의 한 변의 크기 N(1 ≤ N ≤ 100)
		 
		// 공사 지도의 정보
		map = new int[N][N];
		v = new boolean[N][N][4][25];	//  x, y, d, v
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	//각 구역 통제 시작 시각 X (0 ≤ X ≤ 100) [X가 0이라면 통제 X]
				if (map[i][j] == 0) map[i][j] = INF;
			}
		}
		result = INF;
		
		bfs();
		//정훈이가 (N, N)에 도착할 수 있는 최소 시간을 출력한다.
		System.out.println(result == INF?"Fired":result);
	}

	private static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {0,0,0,1,0});	//x, y, time, v, dir
		
		int dx, dy;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();			
			
			if(poll[2] == map[poll[0]][poll[1]]) continue;

			if (poll[0] == N-1 && poll[1] == N-1) {
				result = poll[2];
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				dx = poll[0];
				dy = poll[1];
				if(d == poll[4]) {
					for (int i = 0; i < poll[3] + 1; i++) {
						// 가속도 붙기(방향전환 후에는 어차피 1)
						dx += dirX[d];
						dy += dirY[d];
						
						if(0<=dx && dx<N && 0<=dy && dy<N) {
							if(map[dx][dy] <= poll[2]) break;
						}
					}
					if(0<=dx && dx<N && 0<=dy && dy<N && !v[dx][dy][d][poll[3]]) {
						if(map[dx][dy] <= poll[2]) continue;
						v[dx][dy][d][poll[3]] = true;
						q.offer(new int[] {dx,dy,poll[2]+1,poll[3]+1,d});
					}
				} else {
					// 그냥 하기
					dx += dirX[d];
					dy += dirY[d];

					if(0<=dx && dx<N && 0<=dy && dy<N && !v[dx][dy][d][poll[3]]) {
						if(map[dx][dy] <= poll[2]) continue;
						v[dx][dy][d][poll[3]] = true;
						q.offer(new int[] {dx,dy,poll[2]+1,1,d});
					}
				}
			}
		}
	}
}