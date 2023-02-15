import java.io.*;
import java.util.*;

public class Solution {
	
	static int result;
	static final int[] DIRX = {1, 0, -1, 0}; //상 우 하 좌
	static final int[] DIRY = {0, 1, 0, -1};
	static int[] startpoint;
	static int[][] map;
		
	static void dfs(int x, int y) {
		if(map[x][y] == 3) {
			result = 1;
			return;
		}
		map[x][y] = 1;
		
		for (int d = 0; d < 4; d++) {
			int dx = x + DIRX[d];
			int dy = y + DIRY[d];
			if (map[dx][dy] != 1) {
				dfs(dx, dy);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			
			result = 0;
			map = new int[100][100];
			int[] startpoint = new int[2];
			
			for (int i = 0; i < 100; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					map[i][j] = Character.valueOf(ch[j]) - '0';
					if (map[i][j] == 2) {
						startpoint[0] = i;
						startpoint[1] = j;
					}
				}
			}
			
			dfs(startpoint[0], startpoint[1]);
			
			sb.append("#"+test_case+" " + result +"\n");
		}
		System.out.println(sb);
		br.close();
	}
}