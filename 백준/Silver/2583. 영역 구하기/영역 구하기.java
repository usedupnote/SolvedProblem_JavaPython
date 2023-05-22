import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};	// 상하좌우
	static int[] dirY = {0,0,-1,1};
	
	static int N, M, result;
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		result = 0;
		
		map = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					map[x][y] = true;
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) continue;
				pq.offer(bfs(i, j));
				result++;
			}
		}
		
		sb.append(result).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		map[x][y] = true;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		int cnt = 0;
		int dx, dy;
		while (!q.isEmpty()) {
			cnt++;
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				
				if (0<=dx && dx<N && 0<=dy && dy<M && !map[dx][dy]) {
					map[dx][dy] = true;
					q.offer(new int[] {dx,dy});
				}
			}
		}
		return cnt;
	}
}