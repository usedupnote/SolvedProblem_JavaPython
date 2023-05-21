import java.io.*;
import java.util.*;

public class Solution {
	static int[] dirX = {1,1,-1,-1};	// 하좌, 하우, 상우, 상좌
	static int[] dirY = {-1,1,1,-1};
	
	static int N, result;
	static int[] startPoint;
	static int[][] map;
	
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
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = -1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startPoint = new int[] {i,j};
					visitMap(i, j, 0, 0, new boolean[101]);
				}
			}
			sb.append("#").append(TC).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void visitMap(int x, int y, int d, int cnt, boolean[] v) {
		if (d==3 && x==startPoint[0] && y==startPoint[1]) {
			result = Math.max(result, cnt);
			return;
		}
		
		if (v[map[x][y]]) return;
		v[map[x][y]] = true;
		
		int dx = x + dirX[d];
		int dy = y + dirY[d];
		
		// 직진
		if (0<=dx && dx<N && 0<=dy && dy<N) {
			visitMap(dx, dy, d, cnt+1, v.clone());
		}
		
		// 회전 (1, 2번 회전)
		if (cnt != 0 && d < 2) {
			d++;
			dx = x + dirX[d];
			dy = y + dirY[d];
			
			if (0<=dx && dx<N && 0<=dy && dy<N) {
				visitMap(dx, dy, d, cnt+1, v.clone());
			}
		} else if (d==2 && x - startPoint[0] == y-startPoint[1]) {// 회전 (마지막 회전)
			d++;
			dx = x + dirX[d];
			dy = y + dirY[d];
			
			if (0<=dx && dx<N && 0<=dy && dy<N) {
				visitMap(dx, dy, d, cnt+1, v.clone());
			}
		}
	}
}