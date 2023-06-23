import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {1,0,-1,0};		//하우좌상
	static final int[] dirY = {0,1,0,-1};
	
	static int N;
	static char[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		v = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		q.offer(new int [] {0,0,0});
		v[0][0] = true;
		
		while (true) {
			int[] poll = q.poll();
			if (poll[0] == N-1 && poll[1] == N-1) {
				return poll[2];
			}
			int dx, dy;
			for (int d = 0; d < 4; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				
				if (0<=dx && dx<N && 0<=dy && dy<N && !v[dx][dy]) {
					v[dx][dy] = true;
					if (map[dx][dy] == '0') {
						q.offer(new int[] {dx,dy,poll[2]+1});
					} else {
						q.offer(new int[] {dx,dy,poll[2]});
					}
				}
			}
		}
	}
}