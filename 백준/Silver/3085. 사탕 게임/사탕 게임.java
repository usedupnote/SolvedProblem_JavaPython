import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,0,1,0};	//상우하좌
	static int[] dirY = {0,1,0,-1};
	
	static int N;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;			
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int dx,dy, result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int dir = 0; dir < 2; dir++) {
					//posX, posY, dir, cnt
					result = Math.max(result, bfs(i,j,dir,1));
				}
				for (int d = 1; d < 3; d++) {
					dx = i + dirX[d];
					dy = j + dirY[d];
					
					if (dx<0 || N<=dx || dy<0 || N<=dy) continue;
					if (map[i][j] == map[dx][dy]) continue;
					
					for (int dir = 0; dir < 2; dir++) {
						//posX, posY, dir, cnt
						char c = map[i][j];
						map[i][j] = map[dx][dy];
						map[dx][dy] = c;
						result = Math.max(result, bfs(i,j,dir,1));
						result = Math.max(result, bfs(dx,dy,dir,1));
						map[dx][dy] = map[i][j];
						map[i][j] = c;
					}
				}
			}
		}
		System.out.println(result);
		br.close();
	}

	private static int bfs(int x, int y, int dir, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int d = dir; d < 4; d+=2) {
			q.offer(new int[] {x,y,d});
		}
		
		int dx,dy;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			dx = poll[0] + dirX[poll[2]];
			dy = poll[1] + dirY[poll[2]];
			
			if (0<=dx && dx<N && 0<=dy && dy<N && map[x][y] == map[dx][dy]) {
				cnt++;
				q.offer(new int[] {dx,dy,poll[2]});
			}
		}
		return cnt;
	}
}