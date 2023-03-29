import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {0,-1,-1,-1,0,1,1,1}; // 좌 좌상 상 상우 우 우하 하 하좌
	static int[] dirY = {-1,-1,0,1,1,1,0,-1};
	static int N, M;
	static int[][] map;
	static ArrayDeque<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = 1;
					q.offer(new int[] {i, j});
				}
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		int[] poll = null;
		while (!q.isEmpty()) {
			poll = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] == 0) {
					map[dx][dy] = map[poll[0]][poll[1]] + 1;
					q.offer(new int[] {dx,dy});
				}
			}
		}
		return map[poll[0]][poll[1]] - 1;
	}
}