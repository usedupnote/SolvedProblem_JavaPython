import java.io.*;
import java.util.*;
 
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static int R = 100;
	static int max, compare;
	static int[] dirX = {0, -1, 0, 1}; // 우 하 좌 상
	static int[] dirY = {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] v;
	
	static void search(int cnt) {
		v = new boolean[N][N];
		compare = 0;
		
		if (cnt == R) return;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > cnt && !(v[i][j])) {
					v[i][j] = true;
					compare += 1;
					dfs(cnt, i, j);
				}
			}
		}
		
		max = Math.max(max, compare);
		search(cnt + 1);
	}
	
	static void dfs(int c, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx = x + dirX[i];
			int dy = y + dirY[i];
			
			if(dx >= 0 && dx < N && dy >= 0 && dy < N  && map[dx][dy] > c && !(v[dx][dy])) {
				v[dx][dy] = true;
				dfs(c, dx, dy);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			max = 0;
			map = new int[N][N];
			v = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			search(0);
			
			sb.append("#" + test_case + " " + max + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}