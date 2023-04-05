import java.io.*;
import java.util.*;

public class Solution {
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

		//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//(2 ≤ N, M ≤ 50)
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			q = new ArrayDeque<>();
			
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = ch[j];
					if		(map[i][j] == 'S') suyeon = new int[] {i, j};		//현재 수연이의 위치는 ‘S’
					else if	(map[i][j] == 'D') god	  = new int[] {i, j};		//여신의 공간은 ‘D’
					else if (map[i][j] == '*') q.offer(new int[] {i, j, 0, 0});	//악마는 ‘*’ == 9
				}
			}
			
			result = 0;
			
			BFS(suyeon[0], suyeon[1], 1);
			//돌의 위치는 ‘X’
			//‘.’는 평범한 지역
			
			//수연이가 “악마의 손아귀”를 벗어나면서 안전 지역에 가기 위한 최소 시간을 출력한다.
			//만약 불가능하면 GAME OVER 를 출력한다.
			sb.append("#").append(TC).append(" ").append(result==0?"GAME OVER":result).append("\n");
		}
		System.out.println(sb);
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