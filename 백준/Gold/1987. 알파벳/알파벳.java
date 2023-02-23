import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dirY = {0, 1, 0, -1};
	static int R, C, result;
	static char[][] map;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch[j];
			}
		}
		result = 0;
		v = new boolean[26];
		
		v[(map[0][0] - 'A')] = true;
		
		dfs(0, 0, 1);
		System.out.println(result);
	}

	static void dfs(int x, int y, int count) {
		result = Math.max(result, count);
		
		for (int d = 0; d < 4; d++) {
			int dx = x + dirX[d];
			int dy = y + dirY[d];
			
			if (0<=dx && dx <R && 0<=dy && dy<C && !v[(int)(map[dx][dy] - 'A')]) {
				v[(map[dx][dy] - 'A')] = true;
				dfs(dx, dy, count + 1);
				v[(map[dx][dy] - 'A')] = false;
			}
		}
	}
}