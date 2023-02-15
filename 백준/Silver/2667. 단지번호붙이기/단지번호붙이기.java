import java.io.*;
import java.util.*;

public class Main {
	static int N, count;
	static final int[] DIRX = {1, 0, -1, 0}; //상 우 하 좌
	static final int[] DIRY = {0, 1, 0, -1};
	static int[][] map;
	
	static PriorityQueue<Integer> result;
	static ArrayDeque<int[]> ad;
		
	static void bfs(int x, int y) {
		ad.offer(new int[] {x, y});
		map[x][y] = 0;
		count++;
		
		int check = 0;
		while (!ad.isEmpty()) {
			check++;
			
			int[] now = ad.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = now[0] + DIRX[d];
				int dy = now[1] + DIRY[d];
				
				if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] == 1) {
					map[dx][dy] = 0;
					ad.offer(new int[] {dx, dy});
				}
			}
		}
		result.offer(check);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		count = 0;
		
		map = new int[N][N];
		ad = new ArrayDeque<>();
		result = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.valueOf(ch[j]) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		sb.append(count + "\n");
		
		while (!result.isEmpty()) {
			sb.append(result.poll() + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}