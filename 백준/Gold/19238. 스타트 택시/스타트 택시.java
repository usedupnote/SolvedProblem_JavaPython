import java.io.*;
import java.util.*;

public class Main {
	static class Texi {
		int x, y;
		long oil;	// oil : 연료의 양
		
		public Texi(int x, int y, long oil) {
			this.x = x;
			this.y = y;
			this.oil = oil;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", oil=" + oil + "]";
		}
	}
	
	static final int[] dirX = {-1, 0, 0, 1}; // 상 좌 우 하
	static final int[] dirY = {0, -1, 1, 0};
	
	static int N, M; // N : 맵의 크기, M : 총 승객의 수
	static long oil; // 
	static int[][] map;
	
	static ArrayList<int[]> person;
	
	static Texi texi;
	
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 첫 줄에 N, M, 그리고 초기 연료의 양이 주어진다. 
		// (2 ≤ N ≤ 20, 1 ≤ M ≤ N2, 1 ≤ 초기 연료 ≤ 500,000) 
		// 연료는 무한히 많이 담을 수 있기 때문에, 초기 연료의 양을 넘어서 충전될 수도 있다.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());
		
		
		//다음 줄부터 N개의 줄에 걸쳐 백준이 활동할 영역의 지도가 주어진다. 
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				//0은 빈칸, 1은 벽을 나타낸다.
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 다음 줄에는 백준이 운전을 시작하는 칸의 행 번호와 열 번호가 주어진다.
		// 행과 열 번호는 1 이상 N 이하의 자연수이고, 운전을 시작하는 칸은 빈칸이다.
		st = new StringTokenizer(br.readLine());
		int thisX = Integer.parseInt(st.nextToken()) - 1;
		int thisY = Integer.parseInt(st.nextToken()) - 1;
		texi = new Texi(thisX, thisY, oil);
		
		// M개의 줄에 걸쳐 각 승객의 출발지의 행과 열 번호, 그리고 목적지의 행과 열 번호가 주어진다.
		// 모든 출발지와 목적지는 빈칸이고, 모든 출발지는 서로 다르며, 각 손님의 출발지와 목적지는 다르다.
		person = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken()) - 1;
			int startY = Integer.parseInt(st.nextToken()) - 1;
			int destX = Integer.parseInt(st.nextToken()) - 1;
			int destY = Integer.parseInt(st.nextToken()) - 1;
			
			map[startX][startY] = i + 2;
			
			person.add(new int[] {startX, startY, destX, destY});
		}
		
		//모든 손님을 이동시키고 연료를 충전했을 때 남은 연료의 양을 출력한다.
		// 단, 이동 도중에 연료가 바닥나서 다음 출발지나 목적지로 이동할 수 없으면 -1을 출력한다.
		// 모든 손님을 이동시킬 수 없는 경우에도 -1을 출력한다.
		
		for (int i = 0; i < M; i++) {
			if(bfs(0)) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(texi.oil);
	}

	private static boolean bfs(int cnt) {
		// 백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다.
		// 그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객
		// 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객
		// 택시와 승객이 같은 위치에 서 있으면 그 승객까지의 최단거리는 0이다. 연료는 한 칸 이동할 때마다 1만큼 소모된다. 
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] == o2[2]) {
					if(o1[0] == o2[0]) {
						return Integer.compare(o1[1], o2[1]);
					}
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		boolean[][] v = new boolean[N][N];
		
		q.offer(new int[] {texi.x, texi.y, cnt});
		v[texi.x][texi.y] = true;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			// 승객을 찾았을 경우
			if (map[poll[0]][poll[1]] != 0) {
				texi.x = poll[0];
				texi.y = poll[1];
				texi.oil = texi.oil - poll[2];
				if(moveWithCust(person.get(map[poll[0]][poll[1]] - 2), 0)) return true;
				return false;
			}
			
			if (poll[2] > texi.oil) return true;

			// 택시가 빈칸에 있을 때, 상하좌우로 인접한 빈칸 중 하나로 이동할 수 있다.
			// 알고리즘 경력이 많은 백준은 특정 위치로 이동할 때 항상 최단경로로만 이동한다. (bfs)
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<N && !v[dx][dy] && map[dx][dy] != 1) {
					v[dx][dy] = true;
					q.offer(new int[] {dx, dy, poll[2]+1});
				}
			}
		}
		return true;
	}

	private static boolean moveWithCust(int[] cust, int cnt) {
		// 한 승객을 목적지로 성공적으로 이동시키면, 그 승객을 태워 이동하면서 소모한 연료 양의 두 배가 충전된다.
		// 이동하는 도중에 연료가 바닥나면 이동에 실패하고, 그 날의 업무가 끝난다.
		// 승객을 목적지로 이동시킨 동시에 연료가 바닥나는 경우는 실패한 것으로 간주하지 않는다.
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] == o2[2]) {
					if(o1[0] == o2[0]) {
						return Integer.compare(o1[1], o2[1]);
					}
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[2], o2[2]);
			}
		});
		boolean[][] v = new boolean[N][N];

		map[cust[0]][cust[1]] = 0;
		q.offer(new int[] {cust[0], cust[1], cnt});
		v[cust[0]][cust[1]] = true;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			if (cust[2] == poll[0] && cust[3] == poll[1]) {
				texi.x = poll[0];
				texi.y = poll[1];
				texi.oil += poll[2];
				
				return false;
			}
			
			if (poll[2] > texi.oil) return true;

			// 택시가 빈칸에 있을 때, 상하좌우로 인접한 빈칸 중 하나로 이동할 수 있다.
			// 알고리즘 경력이 많은 백준은 특정 위치로 이동할 때 항상 최단경로로만 이동한다. (bfs)
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<N && !v[dx][dy] && map[dx][dy] != 1) {
					v[dx][dy] = true;
					q.offer(new int[] {dx, dy, poll[2]+1});
				}
			}
		}
		return true;
	}
}