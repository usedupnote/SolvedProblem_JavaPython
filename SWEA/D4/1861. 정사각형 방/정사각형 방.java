import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, check;
	static final int[] DIRX = {1, 0, -1, 0}; //상 우 하 좌
	static final int[] DIRY = {0, 1, 0, -1};
	static int[][] map;
	
	static PriorityQueue<int[]> result;
	static ArrayDeque<int[]> ad;
		
	static void bfs(int x, int y) {
		ad.offer(new int[] {x, y});
		
		check = 0;
		while (!ad.isEmpty()) {
			check++;
			int[] now = ad.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = now[0] + DIRX[d];
				int dy = now[1] + DIRY[d];
				
				if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] == map[now[0]][now[1]] + 1) {
					ad.offer(new int[] {dx, dy});
				}
			}
		}
		result.offer(new int[] {map[x][y], check});
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			result = new PriorityQueue<int[]>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] > o2[1]) {
						return -1;
					} else if (o1[1] == o2[1] && o1[0] < o2[0]){
						return -1;
					} else {
						return 1;
					}
				}
			});
			ad = new ArrayDeque<>();
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}

			int[] num = result.poll();
			sb.append("#" + test_case + " " + num[0] + " " + num[1] + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}