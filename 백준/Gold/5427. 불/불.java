import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};	// 상하좌우
	static int[] dirY = {0,0,-1,1};
	static int cnt;
	static int R, C;
	static int[][] map;
	static ArrayDeque<int[]> s;
	static ArrayDeque<int[]> fire;
	
	static boolean fire() {
		//불은 각 지점에서 네 방향으로 확산된다.
		//미로의 가장자리에 접한 공간에서 탈출할 수 있다.
		while (!s.isEmpty()) {
			cnt++;
			int sizeJihun = s.size();
			for (int i = 0; i < sizeJihun; i++) {
				int[] nowJihun = s.poll();
				
				if (map[nowJihun[0]][nowJihun[1]] == -1) continue;

				for (int d = 0; d < 4; d++) {
					int dx = nowJihun[0] + dirX[d];
					int dy = nowJihun[1] + dirY[d];
					
					if(dx<0 || dx>=R || dy<0 || dy>=C) {
						return true;
					} else if(map[dx][dy]==0) {
						map[dx][dy] = 1;
						s.offer(new int[] {dx, dy});
					}
				}
			}

			int sizeFire = fire.size();
			for (int i = 0; i < sizeFire; i++) {
				int[] nowFire = fire.poll();
				
				for (int d = 0; d < 4; d++) {
					int dx = nowFire[0] + dirX[d];
					int dy = nowFire[1] + dirY[d];
					
					if(0<=dx && dx<R && 0<=dy && dy<C && map[dx][dy]!=-1) {
						map[dx][dy] = -1;
						fire.offer(new int[] {dx, dy});
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	//TestCase 수
		
		for (int test_case = 0; test_case < T; test_case++) {
			s = new ArrayDeque<>();
			fire = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			
			for (int i = 0; i < R; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					if(ch[j] == '#') {
						map[i][j] = -1;
					} else if(ch[j] == '@') {
						map[i][j] = 1;
						s.offer(new int[] {i,j});
					} else if(ch[j] == '*') {
						map[i][j] = -1;
						fire.offer(new int[] {i,j});
					}
				}
			}
			cnt = 0;
			if(s.peek()[0]==0 || s.peek()[0]==R-1 || 0==s.peek()[1] || s.peek()[1]==C-1){
				System.out.println(1);
			} else {
				System.out.println(fire()?cnt:"IMPOSSIBLE");
			}
		}
	}
}