import java.io.*;
import java.util.*;

public class Main {
	static int N, M, maximum; // N : 가로, M : 세로
	static int[][] map;
	
	static int[] dirX = {1, 0, 0};	// 하
	static int[] dirY = {0, -1, 1};	//   좌 우
	
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maximum = 0;
			
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				v[i][j] = false;
			}
		}
		
		System.out.println(maximum);
	}

	static void dfs(int x, int y, int cnt, int score) {
		
		if(cnt == 4) {
			maximum = Math.max(maximum, score);
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int dx = x + dirX[d];
			int dy = y + dirY[d];
			
			if (0<=dx && dx<N && 0<=dy && dy<M && !v[dx][dy]) {
				v[dx][dy] = true;
				if(cnt == 2) {
					dfs(x, y, cnt + 1, score + map[dx][dy]);
				}
				dfs(dx, dy, cnt + 1, score + map[dx][dy]);
				v[dx][dy] = false;
			}
		}
	}
}