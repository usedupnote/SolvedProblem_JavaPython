import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {0, 0, 1, 1}; // 좌상 우상 좌하 우하
	static final int[] dirY = {0, 1, 0, 1};
	static int N, resultMax, resultMin;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	static ArrayDeque<Integer> ad = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.valueOf(ch[j]) - '0';
			}
		}
		Division(N, 0, 0);
		
		System.out.println(sb);
	}

	static void Division(int cnt, int x, int y) {
		int check = map[x][y];
		label : for (int i = x; i < x + cnt; i++) {
			for (int j = y; j < y + cnt; j++) {
				if(check != map[i][j]) {
					check = -1;
					break label;
				}
			}
		}
		if (check == -1) {
			sb.append('(');
			for (int d = 0; d < 4; d++) {
				Division(cnt/2, x + ((cnt / 2) * dirX[d]), y + ((cnt / 2) * dirY[d]));
			}
			sb.append(')');
		} else {
			sb.append(check);
		}
	}
}