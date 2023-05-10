import java.io.*;
import java.util.*;

public class Main {
	static class Ground {
		int x, y, height;

		public Ground(int x, int y, int height) {
			super();
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}

	static final int[] dirX = {-1,1,0,0};	//상하좌우
	static final int[] dirY = {0,0,-1,1};
	
	static int N;
	static int[][] map, v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Ground> q = new PriorityQueue<>(new Comparator<Ground>() {

			@Override
			public int compare(Ground o1, Ground o2) {
				return Integer.compare(o1.height, o2.height);
			}
		});
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				q.offer(new Ground(i, j, map[i][j]));
			}
		}
		
		int safeArea = 1;
		Ground poll;

		v = new int[N][N];
		
		while (!q.isEmpty()) {
			poll = q.poll();
			v[poll.x][poll.y] = 100;
			
			while (!q.isEmpty() && poll.height == q.peek().height) {
				poll = q.poll();
				v[poll.x][poll.y] = 100;
			}
			int currentSafeArea = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j] >= poll.height) continue;
					bfs(i, j, poll.height);
					currentSafeArea++;
				}
			}
			safeArea = Math.max(safeArea, currentSafeArea);
		}
		System.out.println(safeArea);
	}

	static void bfs(int x, int y, int height) {
		ArrayDeque<int[]> aq = new ArrayDeque<>();
		
		v[x][y] = height;
		aq.offer(new int[] {x, y});
		
		while (!aq.isEmpty()) {
			int[] poll = aq.poll();
			
			int dx, dy;
			for (int d = 0; d < 4; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<N && v[dx][dy]<height) {
					v[dx][dy] = height;
					aq.offer(new int[] {dx, dy});
				}
			}
		}
	}
}