import java.io.*;
import java.util.*;

public class Main {
	//제한
	//2 ≤ N ≤ 6
	//1 ≤ Q ≤ 1,000
	//0 ≤ A[r][c] ≤ 100
	//0 ≤ Li ≤ N
	static int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dirY = {0, 1, 0, -1};
	static int N, Q, mapSize, result, maxIce;
	static int[][] map;
	static boolean[][] v;
	
	static void fireStorm(int L) {
		// 파이어스톰은 먼저 격자를 2L × 2L 크기의 부분 격자로 나눈다.
		for (int i = 0; i < mapSize; i += L) {
			for (int j = 0; j < mapSize; j += L) {
				rotate(i, j, L);
			}
		}
		
		// 이후 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
		// (r, c)와 인접한 칸 = 상하좌우
		int[][] copyMap = new int[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if (map[i][j] == 0) continue;
				int group = 0;
				for (int d = 0; d < 4; d++) {
					int di = i + dirX[d];
					int dj = j + dirY[d];
					
					if(0<=di && di < mapSize && 0<=dj && dj<mapSize && map[di][dj] != 0) {
						group++;
					}
				}
				if (group < 3) copyMap[i][j]--;
			}
		}

		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	static void rotate(int x, int y, int L) {
		// 그 후, 모든 부분 격자를 시계 방향으로 90도 회전시킨다.
		int[][] compareMap = new int[L][L];
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				compareMap[j][L - i - 1] = map[x + i][y + j];
			}
		}
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				map[x + i][y + j] = compareMap[i][j];
			}
		}
	}

	static void bfs(int i, int j) {
		int compareIce = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		v[i][j] = true;
		q.offer(new int[] {i,j});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int di = poll[0] + dirX[d];
				int dj = poll[1] + dirY[d];

				if(0<=di && di < mapSize && 0<=dj && dj<mapSize && map[di][dj] != 0 && !v[di][dj]) {
					v[di][dj] = true;
					compareIce++;
					q.offer(new int[] {di, dj});
				}
			}
		}
		maxIce = Math.max(compareIce, maxIce);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		//입력
		// 첫째 줄에 N과 Q가 주어진다.
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		// 둘째 줄부터 2^N개의 줄에는 격자의 각 칸에 있는 얼음의 양이 주어진다.
		
		// map size 설정
		mapSize = 1;
		for (int i = 0; i < N; i++) mapSize *= 2;
		
		map = new int[mapSize][mapSize];
		
		// r번째 줄에서 c번째 주어지는 정수는 A[r][c] 이다.
		for (int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 마지막 줄에는 마법사 상어가 시전한 단계 L1, L2, ..., LQ가 순서대로 주어진다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int skill = 2;
			// 파이어스톰을 시전하려면 시전할 때마다 단계 L을 결정해야 한다. (단계 L마다 
			int L = (int) Math.pow(skill, Integer.parseInt(st.nextToken()));
			fireStorm(L);
		}

		//출력
		result = 0;
		maxIce = 0;
		v = new boolean[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if(map[i][j] == 0) continue;
				// 남아있는 얼음 A[r][c]의 합
				result += map[i][j];
				// 남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수 (덩어리가 없으면 0)
				if(v[i][j]) continue;
				bfs(i, j);
			}
		}
		System.out.println(result + "\n" + maxIce);
	}
}