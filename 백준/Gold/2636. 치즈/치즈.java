import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1,1,0,0}; // 상하좌우
	static final int[] dirY = {0,0,-1,1};
	
	static int N, M, size;
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//사각형 모양 판의 세로와 가로의 길이 (최대 100)
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())==0?false:true;
			}
		}
		int cnt = 0;
		while (bfs()) cnt++;
		
		System.out.println(cnt + "\n" + size);
	}

	private static boolean bfs() {
		boolean[][] v = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		ArrayDeque<int[]> checkMap = new ArrayDeque<>();
		
		q.offer(new int[] {0,0});
		
		v[0][0] = true;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<M && !v[dx][dy]) {
					v[dx][dy] = true;
					if(!map[dx][dy]) {
						q.offer(new int[] {dx,dy});
					}
					else checkMap.offer(new int[] {dx,dy});
				}
			}
		}
		
		if(checkMap.isEmpty()) return false;
		
		size = checkMap.size();
		
		while (!checkMap.isEmpty()) {
			int[] poll = checkMap.poll();
			map[poll[0]][poll[1]] = false;
		}
		return true;
	}
}