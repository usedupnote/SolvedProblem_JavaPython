import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1,-1,0,1,1,1,0,-1};	//상 상우 우 우하 하 하좌 좌 좌상
	static final int[] dirY = {0,1,1,1,0,-1,-1,-1};
	static final int MV = Integer.MAX_VALUE;
	
	static int N, M;
	static int[][] map;
	
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==1) {
					map[i][j] = 0;
					q.offer(new int[] {i, j});
				} else {
					map[i][j] = MV;
				}
			}
		}
        int dx, dy;
        int result = 0;
        
        while (!q.isEmpty()) {
			int[] poll = q.poll();
			for (int d = 0; d < 8; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				
				if (0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] > map[poll[0]][poll[1]]+1) {
					map[dx][dy] = map[poll[0]][poll[1]]+1;
					q.offer(new int[] {dx,dy});
					result = Math.max(result, map[dx][dy]);
				}
			}
		}
        System.out.println(result);
        br.close();
    }
}