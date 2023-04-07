import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dirX = {1,0}; // 하우
	static final int[] dirY = {0,1};
	
	static int N, X, result;
	static int[][] map;
	static ArrayDeque<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		//총 테스트 케이스의 개수 T
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		//다음 N 개의 줄에는 N * N 크기의 지형 정보가 주어진다.
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//지도의 한 변의 크기인 N( 6 ≤ N ≤ 20 )
			X = Integer.parseInt(st.nextToken());	//경사로의 길이 X( 2 ≤ X ≤ 4 )
			//[Fig. 1] 과 같은 N * N 크기의 절벽지대에 활주로를 건설하려고 한다.
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	// 1 <= 지형의 높이 <= 6
				}
			}
			
			result = 0;
			
			for (int i = 0; i < N; i++) {
				makeRoad(i);
			}
			
			//정답은 활주로를 건설할 수 있는 경우의 수이다.
			sb.append("#").append(TC).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
        br.close();
	}

	private static void makeRoad(int pos) {
		int dx, dy;
		for (int d = 0; d < 2; d++) {
			dx = pos * dirY[d];
			dy = pos * dirX[d];
			int cx, cy;
			int cnt = 1;
			while (true) {
				cx = dx + dirX[d];
				cy = dy + dirY[d];
				
				if(0<=cx && cx<N && 0<=cy && cy<N) {
					if(Math.abs(map[cx][cy] - map[dx][dy]) >= 2) break;
					if (map[cx][cy] > map[dx][dy]) {
						// 나보다 높은 지형이 들어올 때
						cnt -= X;
						if(cnt < 0) break;
						cnt = 0;
						
					} else if(map[cx][cy] < map[dx][dy]) {
						// 나보다 낮은 지형이 들어올 때
						if(cnt < 0) break;
						cnt = -X;
					}
					cnt++;
					dx = cx;
					dy = cy;
				} else {
					if(cnt >= 0) result++;
					break;
				}
			}
		}
	}
}