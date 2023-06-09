import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {0,0,1,-1};	//동서남북
	static final int[] dirY = {1,-1,0,0};
	static final int[] dirZ = {1,-1};	// 상하
	
	static int L, R, C;
	static char[][][] map;
	static int[][][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		while (L + R + C != 0) {
			map = new char[L][R][];
			v = new int[L][R][C];
			
			ArrayDeque<int[]> q = new ArrayDeque<>();	// 시작지점 저장 + 이동 순서에 따라서 BFS 저장
			int[] endPoint = {0,0,0};	// 종료지점 저장
			
			// 1. 맵 저장
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					map[i][j] = br.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						if (q.isEmpty() && map[i][j][k] == 'S') {
							q.offer(new int[] {i,j,k});
							v[i][j][k] = 1;
						} else if (map[i][j][k] == 'E') {
							endPoint = new int[] {i,j,k};
						}
					}
				}
				st = new StringTokenizer(br.readLine());
			}

			// 2. 맵 탈출
			start: while (!q.isEmpty()) {
				int[] poll = q.poll();
				
				int dx, dy, dz;
				for (int d = 0; d < 4; d++) {
					dx = poll[1] + dirX[d];
					dy = poll[2] + dirY[d];
					
					if (0<=dx && dx<R && 0<=dy && dy<C) {
						if (map[poll[0]][dx][dy] != '#' && v[poll[0]][dx][dy] == 0) {
							v[poll[0]][dx][dy] = v[poll[0]][poll[1]][poll[2]] + 1;
							q.offer(new int[] {poll[0], dx, dy});
						}
						if (map[poll[0]][dx][dy] == 'E') {
							sb.append("Escaped in ").append(v[poll[0]][dx][dy]-1).append(" minute(s).\n");
							break start;
						}
					}
				}

				for (int d = 0; d < 2; d++) {
					dz = poll[0] + dirZ[d];
					
					if (0<=dz && dz<L) {
						if (map[dz][poll[1]][poll[2]] != '#' && v[dz][poll[1]][poll[2]] == 0) {
							v[dz][poll[1]][poll[2]] = v[poll[0]][poll[1]][poll[2]] + 1;
							q.offer(new int[] {dz, poll[1], poll[2]});
						}
						if (map[dz][poll[1]][poll[2]] == 'E') {
							sb.append("Escaped in ").append(v[dz][poll[1]][poll[2]]-1).append(" minute(s).\n");
							break start;
						}
					}
				}
			}
			
			if (v[endPoint[0]][endPoint[1]][endPoint[2]] == 0) {
				sb.append("Trapped!\n");
			}

			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
        br.close();
	}
}