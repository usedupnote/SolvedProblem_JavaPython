import java.io.*;
import java.util.*;

public class Solution {
	static int[] dirX = {-1,0,1,0};	//상우하좌
	static int[] dirY = {0,1,0,-1};
	static int[][] dir = {
			{0,1,2,3},	//상우하좌
			{0,2},		//상하
			{1,3},		//우좌
			{0,1},		//상우
			{1,2},		//우하
			{2,3},		//하좌
			{0,3}		//상좌
	};
	
	static int N, M, R, C, L;
	static int[][] map;
	static ArrayDeque<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//첫 줄에 총 테스트 케이스의 개수 T가 주어진다.
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		//두 번째 줄부터 T개의 테스트 케이스가 차례대로 주어진다.
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//지도의 세로 크기 N
			M = Integer.parseInt(st.nextToken());	//가로 크기 M
			R = Integer.parseInt(st.nextToken());	//맨홀 뚜껑 세로 위치 R
			C = Integer.parseInt(st.nextToken());	//맨홀 뚜껑 가로 위치 C
			L = Integer.parseInt(st.nextToken());	//탈출 후 소요된 시간 L
			
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			q = new ArrayDeque<>();
			
			q.offer(new int[] {R, C, L-1});
			int cnt = 1;
			
			boolean[][] v = new boolean[N][M];
			
			v[R][C] = true;
			
			while (!q.isEmpty()) {
				int[] poll = q.poll();
				if(poll[2] <= 0) continue;
				
				for (int d:dir[map[poll[0]][poll[1]] - 1]) {
					int dx = poll[0] + dirX[d];
					int dy = poll[1] + dirY[d];
					
					if(0<=dx && dx<N && 0<=dy && dy<M && !v[dx][dy] && map[dx][dy] != 0) {
						
						for (int cd:dir[map[dx][dy] - 1]) {
							if(cd != ((d+2)%4)) continue;
							cnt++;
							v[dx][dy] = true;
							q.offer(new int[] {dx,dy,poll[2]-1});
						}
					}
				}
			}
			sb.append("#" + TC + " " + cnt + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}