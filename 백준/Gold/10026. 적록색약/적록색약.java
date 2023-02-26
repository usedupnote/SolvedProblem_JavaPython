import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dirY = {0, 1, 0, -1}; 
	static int N;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][N];
	    
	    for (int i = 0; i < N; i++) {
	    	char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (ch[j] == 'R') map[i][j] = 0;
				if (ch[j] == 'G') map[i][j] = 1;
				if (ch[j] == 'B') map[i][j] = 2;
			}
		}

	    v = new boolean[N][N];
	    int result = 0;
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j]) continue;
				result++;
				bfs1(i, j);
			}
		}
	    
	    sb.append(result + " ");
	    
	    result = 0;
	    
	    v = new boolean[N][N];
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j]) continue;
				result++;
				bfs2(i, j, map[i][j]);
			}
		}
	    sb.append(result);
	    
	    System.out.println(sb);
	}
	
	static void bfs1(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		v[x][y] = true;
		
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int di = poll[0] + dirX[d];
				int dj = poll[1] + dirY[d];
				
				if(0<=di && di<N && 0<=dj && dj<N && map[di][dj] == map[poll[0]][poll[1]] && !v[di][dj]) {
					v[di][dj] = true;
					q.offer(new int[] {di, dj});
				}
			}
			if(map[poll[0]][poll[1]] != 2) map[poll[0]][poll[1]] = 3;
		}
	}
	
	static void bfs2(int x, int y, int current) {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		v[x][y] = true;
		
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int di = poll[0] + dirX[d];
				int dj = poll[1] + dirY[d];
				
				if(0<=di && di<N && 0<=dj && dj<N && map[di][dj] == current && !v[di][dj]) {
					v[di][dj] = true;
					q.offer(new int[] {di, dj});
				}
			}
		}
	}
}