import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {0,0,-1,1,0,0};	// 상 하 뒤 앞 좌 우
	static int[] dirY = {0,0,0,0,-1,1};
	static int[] dirZ = {-1,1,0,0,0,0};
	
	static ArrayDeque<int[]> q;
	static int N, M, H, cnt;
	static int[][][] map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//상자의 크기를 나타내는 두 정수 M,N

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	//M은 상자의 가로 칸의 수 (2 ≤ N ≤ 100)
		N = Integer.parseInt(st.nextToken());	//N은 상자의 세로 칸의 수 (2 ≤ M ≤ 100)
		H = Integer.parseInt(st.nextToken());	//쌓아올려지는 상자의 수를 나타내는 H	(1 ≤ H ≤ 100)

		cnt = 0;
		map = new int[H][N][M];
		q = new ArrayDeque<>();
		
		
		//N개의 줄이 H번 반복하여 주어진다.
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					//정수 1은 익은 토마토
					//정수 0 은 익지 않은 토마토
					//정수 -1은 토마토가 들어있지 않은 칸
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if	   (map[h][n][m] == 1) q.offer(new int[] {h, n, m, 0});
					else if(map[h][n][m] == 0) cnt++;
				}
			}
		}
		
		System.out.println(BFS());
		//철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
		//창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
		//토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.


		//여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
	}

	private static int BFS() {
		int date = 0;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			date = poll[3];
			
			for (int d = 0; d < 6; d++) {
				int dx = poll[1] + dirX[d];
				int dy = poll[2] + dirY[d];
				int dz = poll[0] + dirZ[d];
				
				if(0<=dx&&dx<N && 0<=dy&&dy<M && 0<=dz&&dz<H && map[dz][dx][dy] == 0) {
					map[dz][dx][dy] = 1;
					cnt--;
					q.offer(new int[] {dz,dx,dy,poll[3] + 1});
				}
			}
		}
		return cnt==0?date:-1;
	}
}