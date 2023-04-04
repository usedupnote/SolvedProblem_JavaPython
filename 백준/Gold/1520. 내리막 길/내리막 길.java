import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1,1,0,0};	//상하좌우
	static final int[] dirY = {0,0,-1,1};
	static int N, M;
	static int[][] map;
	static int[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다.
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			//이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다.
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		v = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(v[i], -1);
		}
		v[M-1][N-1] = 1;

		DFS(0,0);
		
		//첫째 줄에 이동 가능한 경로의 수 H를 출력한다. 모든 입력에 대하여 H는 10억 이하의 음이 아닌 정수이다.
		System.out.println(v[0][0]);
	}
	private static int DFS(int x, int y) {
		if (v[x][y] != -1) return v[x][y];

		v[x][y] = 0;
		
		for (int d = 0; d < 4; d++) {
			int dx = x + dirX[d];
			int dy = y + dirY[d];
			
			if(0<=dx && dx<M && 0<=dy && dy<N) {
				if(map[x][y] > map[dx][dy]) {
					v[x][y] += DFS(dx, dy);
				}
			}
		}
		return v[x][y];
	}
}