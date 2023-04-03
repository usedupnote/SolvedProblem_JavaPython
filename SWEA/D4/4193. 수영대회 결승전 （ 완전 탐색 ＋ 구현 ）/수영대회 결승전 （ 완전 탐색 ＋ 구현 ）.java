import java.io.*;
import java.util.*;

public class Solution {
	static int N, result;
	static int[] dirX = {0,-1,1,0,0}; //0상하좌우
	static int[] dirY = {0,0,0,-1,1};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 수영장의 크기 N  ( 2<=N<=15 )
			
			map = new int[N][N];
			
			//다음 N개의 줄의 i번째 줄에는 수영장의 모양이 공백으로 구분되어 주어진다. ( 0 : 지나갈 수 있는 곳 , 1 : 장애물 , 2: 주기가 2초인 소용돌이)
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					//이 공간에는 섬과 같은 지나갈 수 없는 장애물과, 주기적으로 사라졌다 나타나는 소용돌이 같은 장애물이 존재한다.
					//(섬과 같은 장애물은 지도에서 1로 표시, 소용돌이 같은 장애물은 2로 표시)
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작위치 A,B ( 0<=A,B<=N-1)
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
					
			// 도착위치 C, D ( 0 <=C,D<=N-1) ( 도착점과 시작점은 소용돌이가 아니다 )
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			result = -1;
			
			tornado(0,A,B,C,D);
			
			//각 테스트 케이스마다 테스트 케이스의 번호와 이동시간을 공백을 두고 표시한다 
			//도착 할 수 없다면 -1을 출력한다.
			sb.append("#" + TC + " " + result + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void tornado(int cnt, int x, int y,int destX, int destY) {
		boolean[][] v = new boolean[N][N];
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {cnt,x,y});
		
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			if(poll[1] == destX && poll[2] == destY) {
				result = poll[0];
				break;
			}
			
			
			for (int d = 1; d < 5; d++) {
				int dx = poll[1] + dirX[d];
				int dy = poll[2] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<N) {
					if(map[dx][dy]==1) continue;
					if(map[dx][dy]==2) {
						if((poll[0] % 3)!=2) {
							queue.offer(new int[] {poll[0]+1, poll[1], poll[2]});
							continue;	//소용돌이는 생성되고 2초동안 유지되다가 1초동안 잠잠해진다.
						}
					}
					if(v[dx][dy]) continue;
					
					v[dx][dy] = true;
					queue.offer(new int[] {poll[0]+1, dx, dy});
				}
			}
		}
	}
}