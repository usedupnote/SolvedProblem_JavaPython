import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1,1,0,0}; // 상하좌우
	static final int[] dirY = {0,0,-1,1};
	static final char[] chset = {'*'};
	
	static int N, M, result;
	static int[] god, suyeon;
	static char[][] map;
	static ArrayDeque<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j];
				if		(map[i][j] == 'S') suyeon = new int[] {i, j};		
				else if	(map[i][j] == 'D') god	  = new int[] {i, j};	
				else if (map[i][j] == '*') q.offer(new int[] {i, j, 0, 0});
			}
		}
		
		result = 0;
		
		BFS(suyeon[0], suyeon[1], 1);
		
		System.out.println(result==0?"KAKTUS":result);
		br.close();
	}
	private static void BFS(int x, int y, int cnt) {
		q.offer(new int[] {x, y, cnt, 1});
		
		int dx, dy;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();

			for (int d = 0; d < 4; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				if(0<=dx && dx<N && 0<=dy && dy<M) {
					
					if(poll[3] == 0) {
						if(map[dx][dy] == '.' || map[dx][dy] == 'S') {
							map[dx][dy] = '*';
							q.offer(new int[] {dx,dy,poll[2]+1, poll[3]});
						}
					}else {
						if(map[dx][dy] == 'D') {
							result = poll[2];
							return;
						}
						if(map[dx][dy] == '.') {
							map[dx][dy] = 'S';
							q.offer(new int[] {dx,dy,poll[2]+1, poll[3]});
						}
					}
				}
			}
		}
	}
}