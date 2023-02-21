import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX1 = {-1, 0, 1, 0}; // 상우하좌
	static int[] dirX2 = {1, 0, -1, 0}; // 하우상좌
	static int[] dirY = {0, 1, 0, -1}; 
	static int R, C, T, airCleanerPos, result;
	static int[][] map;
	static boolean[] v = new boolean[10];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());	//T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양
		
		map = new int [R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 2; i < R; i++) {
			if(map[i][0] == -1) {
				airCleanerPos = i;
				break;
			}
		}
		
		// T 초간 일어나는 일
		for (int i = 0; i < T; i++) {
			// 1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
			dif();
			// 2. 공기청정기가 작동한다.
			airClean(airCleanerPos);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += map[i][j];
			}
		}
		
		System.out.println(result + 2);
	}
	
	private static void dif() {
		
		// 연산용 맵 생성
		int[][] copyMap = new int [R][C];
		
		// 확산
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					int amountOfDif = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int dx = i + dirX1[d];
						int dy = j + dirY[d];
						
						if(0<=dx && dx<R && 0<=dy && dy<C && map[dx][dy] != -1) {
							copyMap[i][j] -= amountOfDif;
							copyMap[dx][dy] += amountOfDif;
						}
					}
					copyMap[i][j] += map[i][j];
				}
			}
		}
		
		
		// 결과값 반영
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
		
		map[airCleanerPos][0] = -1;
		map[airCleanerPos + 1][0] = -1;
	}

	static void airClean(int x) {
		for (int dir = 0; dir < 2; dir++) {
			int dx = x + dir;
			int dy = 0;
			
			for (int d = 0; d < 4; d++) {
				if(dir == 0) {
					dx += dirX1[d];
					dy += dirY[d];
					
					while (0 <= dx && dx <= x && 0 <= dy && dy < C) {
						map[dx-dirX1[d]][dy-dirY[d]] = map[dx][dy];
						dx += dirX1[d];
						dy += dirY[d];
					}
					dx -= dirX1[d];
					dy -= dirY[d];
				} else {
					dx += dirX2[d];
					dy += dirY[d];
					
					while (x < dx && dx < R && 0 <= dy && dy < C) {
						map[dx-dirX2[d]][dy-dirY[d]] = map[dx][dy];
						dx += dirX2[d];
						dy += dirY[d];
					}
					
					dx -= dirX2[d];
					dy -= dirY[d];
				}
			}
		}
		
		// 공기청정기 위치에 다시 -1 및 그 옆을 0으로 설정
		map[airCleanerPos][0] = -1;
		map[airCleanerPos + 1][0] = -1;
		map[airCleanerPos][1] = 0;
		map[airCleanerPos + 1][1] = 0;
	}
}