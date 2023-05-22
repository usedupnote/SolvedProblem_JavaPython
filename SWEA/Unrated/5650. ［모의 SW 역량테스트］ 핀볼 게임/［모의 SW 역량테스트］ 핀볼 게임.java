import java.io.*;
import java.util.*;

public class Solution {
	static int[] dirX = {-1,0,1,0}; // 상 우 하 좌
	static int[] dirY = {0,1,0,-1};
	static int N;
	static int[][] map;
	static int[][][] hole;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			hole = new int[11][2][];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 5) {
						if (hole[map[i][j]][0] == null) {
							hole[map[i][j]][0] = new int[] {i,j};
						}else {
							hole[map[i][j]][1] = new int[] {i,j};
						}
					}
				}
			}
			
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) continue;
					for (int d = 0; d < 4; d++) {
						result = Math.max(result, trip(i, j, d, 0));
					}
				}
			}
			sb.append("#").append(TC).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static int trip(int x, int y, int d, int cnt) {
		int dx = x, dy = y;
		while (true) {
			dx += dirX[d];
			dy += dirY[d];

			if (0>dx || dx>=N || 0>dy || dy>=N ) {
				return cnt * 2 + 1;
			}
			if (dx == x && dy == y) {
				return cnt;
			}
			if (map[dx][dy] == 0) {
				continue;
			}
			if (map[dx][dy] == 5) {
				return cnt * 2 + 1;
			}
			if (map[dx][dy] == -1) {
				return cnt;
			}
			
			if (map[dx][dy] == 1) {
				if (d == 2) {
					cnt++;
					d = 1;
				} else if (d == 3) {
					cnt++;
					d = 0;
				} else {
					return cnt * 2 + 1;
				}
			}
			if (map[dx][dy] == 2) {
				if (d == 0) {
					cnt++;
					d = 1;
				} else if (d == 3) {
					cnt++;
					d = 2;
				} else {
					return cnt * 2 + 1;
				}
			}
			if (map[dx][dy] == 3) {
				if (d == 1) {
					cnt++;
					d = 2;
				} else if (d == 0) {
					cnt++;
					d = 3;
				} else {
					return cnt * 2 + 1;
				}
			}
			if (map[dx][dy] == 4) {
				if (d == 1) {
					cnt++;
					d = 0;
				} else if (d == 2) {
					cnt++;
					d = 3;
				} else {
					return cnt * 2 + 1;
				}
			} 
			
			if (map[dx][dy] > 5) {
				int[] a = hole[map[dx][dy]][0];
				int[] b = hole[map[dx][dy]][1];
				
				if (dx == a[0] && dy ==a[1]) {
					dx = b[0];
					dy = b[1];
				} else {
					dx = a[0];
					dy = a[1];
				}
			}
		}
	}
}