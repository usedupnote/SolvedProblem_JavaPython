import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 상우 우 우하 하 하좌 좌 좌상
	static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
	static int W, H, result;
	static int[][] map;
	/*
	static void bfs() {
		
	}
	*/
	static void dfs(int x, int y) {
		map[x][y] = 0;
		for (int d = 0; d < 8; d++) {
			int dx = x + dirX[d];
			int dy = y + dirY[d];
			
			if(0 <= dx && dx < H && 0 <= dy && dy < W && map[dx][dy] == 1) {
				dfs(dx, dy);
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	// w와 h는 50보다 작거나 같은 양의 정수이다.
    	W = Integer.parseInt(st.nextToken());
    	H = Integer.parseInt(st.nextToken());
    	
    	// 입력의 마지막 줄에는 0이 두 개 주어진다.
    	while (W != 0 && H != 0) {
    		// 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
    		result = 0;
    		map = new int[H][W];
    		
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == 1) {
						result += 1;
						// bfs(i, j);
						dfs(i, j);
					}
				}
			}
			
			sb.append(result + "\n");
			
			st = new StringTokenizer(br.readLine());
	    	W = Integer.parseInt(st.nextToken());
	    	H = Integer.parseInt(st.nextToken());
		}
    	System.out.println(sb);
    	
    	br.close();
    }
}