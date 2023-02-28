import java.io.*;
import java.util.*;
 
public class Main {
	static int[] dirX = {-1, 1, 0, 0}; // 상하 좌우
	static int[] dirY = {0, 0, -1, 1};
	static int N, landCnt, minLength;
	static int[][] map, searchMap;
	static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        N = Integer.parseInt(st.nextToken());
         
        map = new int[N][N];
        searchMap = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        landCnt = 1;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if(map[i][j] == 1) {
        			searchLand(i, j);
        		}
        	}
        }
        
        minLength = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if(map[i][j] != 0) {
        			v = new boolean[N][N];
        			findLnd(i, j);
        		}
        	}
        }
        System.out.println(minLength);
    }
    
	static void findLnd(int x, int y) {

		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x, y, 0});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[2] >= minLength) break;
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<N && !v[dx][dy] && map[dx][dy] != map[x][y]) {
					v[dx][dy] = true;
					if(map[dx][dy] != 0) {
						minLength = poll[2];
						break;
					}
					q.offer(new int[] {dx, dy, poll[2] + 1});
				}
			}
		}
	}
	
	static void searchLand(int x, int y) {
		landCnt++;
		
		map[x][y] = landCnt;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<N && map[dx][dy] == 1) {
					map[dx][dy] = landCnt;
					q.offer(new int[] {dx, dy});
				}
			}
		}
	}
}