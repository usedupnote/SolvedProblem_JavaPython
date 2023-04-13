import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};	//상하좌우
	static int[] dirY = {0,0,-1,1};
	static int n, m, cnt, area;
	static int[][] map;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());	//도화지의 세로 크기 n(1 ≤ n ≤ 500)
		m = Integer.parseInt(st.nextToken());	//가로 크기 m(1 ≤ m ≤ 500)
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt( st.nextToken());
			}
		}
		
		area = 0;
		cnt = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 1) continue;
				bfs(i, j, 1);
			}
		}
		System.out.println(cnt - 1 + "\n" + area);
	}
	private static void bfs(int x, int y, int count) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		cnt++;
		
		q.offer(new int[] {x, y});
		
		map[x][y] = cnt;
		
		while (!q.isEmpty()){
			int[] poll = q.poll();
			
			int dx, dy;
			for (int d = 0; d < 4; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<n && 0<=dy && dy<m && map[dx][dy] == 1) {
					map[dx][dy] = cnt;
					count++;
					q.offer(new int[] {dx, dy});
				}
			}
		}
		area = Math.max(area, count);
	}
}