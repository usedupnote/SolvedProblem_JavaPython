import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,-1,0,1,1,1,0,-1};	//상 상우 우 우하 하 좌하 좌 좌상
	static int[] dirY = {0,1,1,1,0,-1,-1,-1};
	
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		br.close();
	}

	private static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy]==1) {
					map[dx][dy] = 0;
					q.offer(new int[] {dx, dy});
				}
			}
		}
	}
}