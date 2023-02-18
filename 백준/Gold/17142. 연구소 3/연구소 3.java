import java.io.*;
import java.util.*;

class Main {
	static final int[] dirX = {1, 0, -1, 0}; // 상 우 하 좌
	static final int[] dirY = {0, 1, 0, -1};
	static int N, M, point, originalEmpty, result;
	static int[][] virus;
	static int[][] map;
	static ArrayDeque<int[]> check;
	static boolean[] v;
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			result = Math.min(result, bfs());
			return;
		}
		
		for (int i = start; i < point; i++) {
			if(v[i]) continue;
			v[i] = true;
			comb(cnt+1, i + 1);
			v[i] = false;
		}
	}
	
	static int bfs() {
		int empty = originalEmpty;
		int last = 0;
		int[][] copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		check = new ArrayDeque<>();
		
		for (int i = 0; i < point; i++) {
			if(v[i]) {
				check.add(virus[i]);
				copyMap[virus[i][0]][virus[i][1]] = 1;
			}
		}
		
		label : while (!check.isEmpty()) {
			int[] now = check.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = now[0] + dirX[d];
				int dy = now[1] + dirY[d];
				
				if(dx >= 0 && dx < N && dy >= 0 && dy < N && copyMap[dx][dy] <= 0) {
					copyMap[dx][dy] = copyMap[now[0]][now[1]] + 1;
					check.offer(new int[] {dx, dy});
					if(map[dx][dy] == 0) {
						empty--;
						last = Math.max(last, copyMap[dx][dy]);
					}
				}
				if (empty == 0) break label;
			}
		}
		
		if(empty > 0) return Integer.MAX_VALUE;
		
		return last;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		originalEmpty = 0;
		result = Integer.MAX_VALUE;
		map = new int[N][N];
		virus = new int[10][];
		v = new boolean[10];
		
		point = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				//map 정보 저장
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 바이러스 위치 저장
				if (map[i][j] == 0) {
					originalEmpty++;
				}else if (map[i][j] == 2) {
					map[i][j] = -1;
					virus[point++] = new int[] {i, j};
				}
			}
		}
		
		if (originalEmpty != 0) {
			comb(0, 0);
		} else {
			result = 1;
		}
		
		System.out.println(result == Integer.MAX_VALUE? -1 : result - 1);
		br.close();
	}
}