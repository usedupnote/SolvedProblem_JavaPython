import java.io.*;
import java.util.*;

public class Main {
	static class Group {
		int cnt;
		PriorityQueue<block> q;
		private void function() {
			
			// 사실 pq 까지 쓸 필요는 없도록 코드 짰으나 혹시 모르니
			q = new PriorityQueue<>(new Comparator<block>() {

				@Override
				public int compare(block o1, block o2) {
					if(o1.x == o2.x) {
						return Integer.compare(o1.y, o2.y);
					}
					return Integer.compare(o2.x, o1.x);
				}
			});
		}
		
		public Group() {
			this.cnt = 1;
			function();
		}
	}
	
	static class block{
		int x, y;

		public block(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dirX = {-1,1,0,0};	// 상하좌우
	static int[] dirY = {0,0,-1,1};
	static int N, M, result;
	static int[][] map;
	static boolean[][] v;
	static Group mainGroup;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//격자 한 변의 크기 N (1 ≤ N ≤ 20)
		M = Integer.parseInt(st.nextToken());	//색상의 개수 M (1 ≤ M ≤ 5)
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				//일반 블록은 M가지 색상이 있고, 색은 M이하의 자연수로 표현한다.
				//검은색 블록은 -1, 무지개 블록은 0으로 표현한다.
				//*추가* 빈 칸은 -2로 표현한다.
				map[i][j] = Integer.parseInt(st.nextToken());	//-1, 0, M이하의 자연수
			}
		}
		
		result = 0;
		
		while (true) {
			mainGroup = new Group();
			
			v = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!v[i][j] && map[i][j] > 0) {
						compare(i, j, map[i][j]);
					}
				}
			}
			
			if (mainGroup.q.size() < 2) break;
			
			result += (mainGroup.q.size() * mainGroup.q.size());
			mainGroup.cnt = 1;
			
			while (!mainGroup.q.isEmpty()) {
				block poll = mainGroup.q.poll();
				map[poll.x][poll.y] = -2;
			}
			move();
		}
		
		//첫째 줄에 획득한 점수의 합을 출력한다.
		System.out.println(result);
		br.close();
	}

	private static void compare(int x, int y, int current) {
		Group compareGroup = new Group();
		ArrayDeque<block> q = new ArrayDeque<>();
		
		boolean[][] visited = new boolean[N][N];
		visited[x][y] = true;
		
		compareGroup.q.offer(new block(x, y));
		q.offer(new block(x, y));
		
		while (!q.isEmpty()) {
			block poll = q.poll();
			int dx, dy;
			for (int d = 0; d < 4; d++) {
				dx = poll.x + dirX[d];
				dy = poll.y + dirY[d];
				
				if (0<=dx && dx<N && 0<=dy && dy<N && !visited[dx][dy]) {
					visited[dx][dy] = true;
					if(map[dx][dy] == current) {
						v[dx][dy] = true;
						q.offer(new block(dx, dy));
						compareGroup.q.offer(new block(dx, dy));

					}else if (map[dx][dy] == 0) {
						compareGroup.cnt++;
						q.offer(new block(dx, dy));
						compareGroup.q.offer(new block(dx, dy));
					}
				}
			}
		}
		
		if (compareGroup.q.size() < 2) return;

		if(mainGroup.q.size() < compareGroup.q.size()) {
			mainGroup.cnt = compareGroup.cnt;
			mainGroup.q.clear();
			mainGroup.q.addAll(compareGroup.q);
		} else if((mainGroup.q.size() == compareGroup.q.size())) {
			if (mainGroup.cnt <= compareGroup.cnt) {
				mainGroup.cnt = compareGroup.cnt;
				mainGroup.q.clear();
				mainGroup.q.addAll(compareGroup.q);
			}
		}
	}

	private static void move() {
		gravity(); 	//격자에 중력이 작용한다.
		rotate();	//격자가 90도 반시계 방향으로 회전한다.
		gravity(); 	//다시 격자에 중력이 작용한다.
	}

	private static void rotate() {
		int[][] copyMap = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[N-j-1][i] = map[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			map[i] = copyMap[i].clone();
		}
	}

	private static void gravity() {
		//격자에 중력이 작용하면 검은색 블록을 제외한 
		//모든 블록이 행의 번호가 큰 칸으로 이동한다.
		for (int i = N-2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] < 0) continue;
				int h = i+1;
				
				while (h<N) {
					if (map[h][j] != -2) break;
					h++;
				}
				h--;
				
				if (map[h][j] == -2) {
					map[h][j] = map[i][j];
					map[i][j] = -2;
				}
			}
		}
	}
}