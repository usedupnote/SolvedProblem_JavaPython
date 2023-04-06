import java.io.*;
import java.util.*;


public class Solution {
	static final int[] dirX = {-1,1,0,0}; // 상하좌우
	static final int[] dirY = {0,0,-1,1};
	
	static int N, M, K;
	static int[] god, suyeon;
	static int[][][] map;
	static ArrayDeque<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		//첫 줄에는 총 테스트 케이스의 개수 T가 주어진다.
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	//(2 ≤ N, M ≤ 50)
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//한 변에 있는 셀의 개수 N (5 ≤ N ≤ 100)
			M = Integer.parseInt(st.nextToken());	//격리 시간 M (1 ≤ M ≤ 1,000)
			K = Integer.parseInt(st.nextToken());	//최초 배치되어 있는 미생물 군집의 개수 K (5 ≤ K ≤ 1,000)
			
			//이 구역은 가로 N개, 세로 N개, 총 N * N 개의 동일한 크기의 정사각형 셀들로 이루어져 있다.
			q = new ArrayDeque<>();
			
			//미생물 군집 K개의 정보가 주어진다.
			int x,y,n,d;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				//미생물 군집의 정보는 세로 위치, 가로 위치, 미생물 수, 이동 방향 순으로 4개의 정수가 주어진다.
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken()) - 1;	//(상: 1, 하: 2, 좌: 3, 우: 4)
				
				q.offer(new int[] {x,y,n,d});
			}
			
			for (int i = 0; i < M; i++) {
				move();
				combine();
			}
			sb.append("#").append(TC).append(" ").append(sum()).append("\n");
		}


		//출력해야 할 정답은 M시간 후 남아 있는 미생물 수의 총 합이다.
		System.out.println(sb);
        br.close();
	}

	private static int sum() {
		int result = 0;
		while (!q.isEmpty()) {
			result += q.poll()[2];
		}
		return result;
	}

	private static void combine() {
		//④ 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다. 
		//  합쳐 진 군집의 미생물 수는 군집들의 미생물 수의 합이며, 이동 방향은 군집들 중 미생물 수가 가장 많은 군집의 이동방향이 된다. 
		//  합쳐지는 군집의 미생물 수가 같은 경우는 주어지지 않으므로 고려하지 않아도 된다.

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j][2] == 0) continue;
				q.offer(new int[] {i, j, map[i][j][2], map[i][j][1]});
			}
		}
	}

	private static void move() {
		map = new int[N][N][3];	//size - dir - combineSize
		
		int size = q.size();
		int dx, dy;
		for (int i = 0 ; i < size ; i++){
			int[] poll = q.poll();
			
			dx = poll[0] + dirX[poll[3]];
			dy = poll[1] + dirY[poll[3]];
			
			if (0==dx || dx==N-1 || 0==dy || dy==N-1) {
				// ③ 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다. 
				if (poll[2]/2 == 0) continue;
				if (map[dx][dy][0] < poll[2]/2) {
					map[dx][dy][0] = poll[2]/2;
					map[dx][dy][1] = ((poll[3]+1) % 2) + (2 * (poll[3]/2));
				}
				map[dx][dy][2] += poll[2]/2;
			}else {
				if (map[dx][dy][0] < poll[2]) {
					map[dx][dy][0] = poll[2];
					map[dx][dy][1] = poll[3];
				}
				map[dx][dy][2] += poll[2];
			}
			
		}
	}
}