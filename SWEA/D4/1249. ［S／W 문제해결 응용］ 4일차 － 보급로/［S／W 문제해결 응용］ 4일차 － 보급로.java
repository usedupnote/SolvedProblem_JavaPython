import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dirX = {-1, 0, 1, 0}; // 상 하 우 좌
	static final int[] dirY = {0, 1, 0, -1};
	static int[][] map;
	static int[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= C; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			v = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			
			int maxV = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(v[i], maxV);
			}

			v[0][0] = 0;
			
			while (true) {
				// step 1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
				int[] current = {0, 0};
				int min = Integer.MAX_VALUE;
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(v[i][j] != maxV) {
							for (int d = 0; d < 4; d++) {
								int dx = i + dirX[d];
								int dy = j + dirY[d];
								
								if(0<=dx && dx<N && 0<=dy && dy<N && v[dx][dy] == maxV && min > map[dx][dy] + v[i][j]) {
									current = new int[] {dx, dy};
									min = map[dx][dy] + v[i][j];
								}
							}
						}
					}
				}
				
				// step 2 : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 인점 정점과의 비용 최소값 갱신		
				if(v[current[0]][current[1]] > min) {
					v[current[0]][current[1]] = min;
				}
				if(current[0] == (N-1) && current[1] == (N-1)) break;
			}
			
			sb.append("#" + test_case + " " + v[N-1][N-1] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}