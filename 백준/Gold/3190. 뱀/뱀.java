import java.io.*;
import java.util.*;
 
public class Main {
	static int[] dirX = {0, 1, 0, -1};	//우 하 좌 상
	static int[] dirY = {1, 0, -1, 0};
	static int N, K, L;
	static boolean checker;
	static int cnt, dir;
	static int[][] map;
	static ArrayDeque<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 보드의 크기 N (2 ≤ N ≤ 100)
		
		map = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());	// 사과의 개수 K (0 ≤ K ≤ 100)

		// 사과의 위치
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;	// 첫 번째 정수는 행 위치
			int y = Integer.parseInt(st.nextToken()) - 1;	// 두 번째 정수는 열 위치
			
			map[x][y] = 1;
		}
		
		map[0][0] = -1;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());	// 뱀의 방향 변환 횟수 L (1 ≤ L ≤ 100)
		checker = true;
		
		// 뱀의 정보
		queue.offer(new int[] {0,0});
		dir = 0;
		cnt = 0;
		// 뱀의 방향 변환 정보
		int time = 0;
		label : for (int i = 0; i < L; i++) {
			// X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻 (0 < X <= 10,000)
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()) - time;
			char C = st.nextToken().charAt(0);
			
			time += X;
			
			for (int j = 0; j < X; j++) {
				cnt++;
				if(game()) break label;
			}
			
			if(C == 'L') {
				dir = (dir + 3) % 4;
			} else {
				dir = (dir + 1) % 4;
			}
		}
		

		while (checker) {
			cnt++;
			if(game()) break;
		}
		
		System.out.println(cnt);
		// 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 난다.

		// 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.
		// 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

		// 첫째 줄에 게임이 몇 초에 끝나는지 출력한다.
	}

	private static boolean game() {
		int[] peek = queue.peekLast();
		int dx = peek[0] + dirX[dir];
		int dy = peek[1] + dirY[dir];
		
		if(0<=dx && dx<N && 0<=dy && dy<N) {
			// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
			if(map[dx][dy] == 1) {			// 사과 O
				map[dx][dy] = -1;
				queue.offer(new int[] {dx, dy});
				return false;
			} else if(map[dx][dy] == 0) {	// 사과 X
				int[] poll = queue.pollFirst();
				map[poll[0]][poll[1]] = 0;
				map[dx][dy] = -1;
				queue.offer(new int[] {dx, dy});
				return false;
				// 벽 또는 자기자신의 몸과 부딪히면 게임이 끝
			} else {						// 본인의 몸
				checker = false;
				return true;
			}
		} else {
			checker = false;
			return true;
		}
		// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
		// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
	}
}