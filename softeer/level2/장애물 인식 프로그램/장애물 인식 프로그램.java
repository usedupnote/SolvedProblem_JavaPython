import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};
	static int[] dirY = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (ch[j]=='1') map[i][j] = true;
			}
		}

		PriorityQueue<Integer> result = new PriorityQueue<Integer>();
		//bfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]) {
					int cnt = 1;
					ArrayDeque<int[]> q = new ArrayDeque<int[]>();
					
					q.offer(new int[] {i, j});
					map[i][j] = false;
					
					int dx, dy;
					while (!q.isEmpty()) {
						int[] poll = q.poll();
						for (int d = 0; d < 4; d++) {
							dx = poll[0] + dirX[d];
							dy = poll[1] + dirY[d];
							
							if (0<=dx && dx<N && 0<=dy && dy<N && map[dx][dy]) {
								map[dx][dy] = false;
								cnt++;
								q.offer(new int[] {dx,dy});
							}
						}
					}
					result.offer(cnt);
				}
			}
		}
		
		sb.append(result.size()).append("\n");
		while (!result.isEmpty()) {
			sb.append(result.poll()).append("\n");
		}
		System.out.println(sb);
	}
}