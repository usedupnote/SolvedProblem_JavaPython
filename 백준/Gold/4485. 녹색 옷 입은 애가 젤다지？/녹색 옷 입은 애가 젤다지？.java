import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1, 0, 0, 1}; // 상 좌 우 하
	static final int[] dirY = {0, -1, 1, 0};
	static final int maxV = Integer.MAX_VALUE;

	static int N, result;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while (N != 0) {
			cnt++;
			map = new int[N][N];
			result = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem " + cnt + ": " + bfs() + "\n");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}

	private static int bfs() {
		int[][] copyMap = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(copyMap[i], maxV);
		}
		
		copyMap[0][0] = map[0][0];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {0, 0});
        
        while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<N) {
					if(copyMap[dx][dy] > copyMap[poll[0]][poll[1]] + map[dx][dy]) {
						q.offer(new int[] {dx, dy}); 
						copyMap[dx][dy] = copyMap[poll[0]][poll[1]] + map[dx][dy];
					}
				}
			}
		}
		return copyMap[N-1][N-1];
	}
}