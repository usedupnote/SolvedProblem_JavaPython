import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};	// 상하좌우
	static int[] dirY = {0,0,-1,1};
	static int cnt;
	static int R, C;
	static int[][] map;
	static ArrayDeque<int[]> jihun = new ArrayDeque<>();
	static ArrayDeque<int[]> fire = new ArrayDeque<>();
	
	static boolean fire() {
		//불은 각 지점에서 네 방향으로 확산된다.
		//지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.
		//지훈이와 불은 벽이 있는 공간은 통과하지 못한다.
		while (!jihun.isEmpty()) {
			cnt++;
			int sizeJihun = jihun.size();
			for (int i = 0; i < sizeJihun; i++) {
				int[] nowJihun = jihun.poll();
				
				if (map[nowJihun[0]][nowJihun[1]] == -1) continue;

				for (int d = 0; d < 4; d++) {
					int dx = nowJihun[0] + dirX[d];
					int dy = nowJihun[1] + dirY[d];
					
					if(dx<0 || dx>=R || dy<0 || dy>=C) {
						return true;
					} else if(map[dx][dy]==0) {
						map[dx][dy] = 1;
						jihun.offer(new int[] {dx, dy});
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
		
		//1 ≤ R, C ≤ 1000
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	//R = 미로 행의 개수
		C = Integer.parseInt(st.nextToken());	//C = 미로 열의 개수
		
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(ch[j] == '#') {			//#: 벽
					map[i][j] = -1;
				} else if(ch[j] == 'J') {	//J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
					map[i][j] = 1;
					jihun.offer(new int[] {i,j});
				} else if(ch[j] == 'F') {	//F: 불이 난 공간
					map[i][j] = -1;
					fire.offer(new int[] {i,j});
				}
			}
		}
		cnt = 0;
		if(jihun.peek()[0]==0 || jihun.peek()[0]==R-1 || 0==jihun.peek()[1] || jihun.peek()[1]==C-1){
			System.out.println(1);
		} else {
			System.out.println(fire()?cnt:"IMPOSSIBLE");
		}
		//지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.
		//지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다.
	}
}
