import java.io.*;
import java.util.*;

public class Main {
	private static final int[] dirX = {-1,1,0,0};	// 상하좌우
	private static final int[] dirY = {0,0,-1,1};
    private static int K, W, H, result;
    private static int[][] map;
    private static int[][][] check;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());	//0 <= K <= 30
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());	//0 <= W <= 200
		H = Integer.parseInt(st.nextToken());	//0 <= H <= 200
		// 0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 장애물이 있는 곳으로는 이동할 수 없다.
			
		map = new int[H][W];
		check = new int[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(check[i][j], Integer.MAX_VALUE);
			}
		}
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	//0 <= W <= 200
			}
		}
		
		result = Integer.MAX_VALUE;
		
		bfs(0,0,0,K);
		
		//첫째 줄에 원숭이의 동작수의 최솟값을 출력한다. 시작점에서 도착점까지 갈 수 없는 경우엔 -1을 출력한다.
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}

	private static void bfs(int x, int y, int cnt, int knight) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		
		q.offer(new int[] {x,y,cnt,knight});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			//격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다.
			if (poll[0] == H-1 && poll[1] == W-1) {
				result = Math.min(result, poll[2]);
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				//인접한 칸으로 이동
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if (0<=dx && dx<H && 0<=dy && dy<W && map[dx][dy] == 0) {
					if(check[dx][dy][poll[3]] > poll[2]) {
						check[dx][dy][poll[3]] = poll[2];
						q.offer(new int[] {dx,dy,poll[2]+1,poll[3]});
					}
				}
				
				//총 K번은 체스의 나이트와 같은 이동방식을 가진다. (말은 장애물을 뛰어넘을 수 있다.)
				if (poll[3] == 0) continue;
				dx += dirX[d];
				dy += dirY[d];
				
				for (int d2 = 2; d2 < 4; d2++) {
					int d2x = dx + dirX[(((d/2)*2)+d2)%4];
					int d2y = dy + dirY[(((d/2)*2)+d2)%4];
					
					if (0<=d2x && d2x<H && 0<=d2y && d2y<W && map[d2x][d2y] == 0) {
						if(check[d2x][d2y][poll[3]-1] > poll[2]) {
							check[d2x][d2y][poll[3]-1] = poll[2];
							q.offer(new int[] {d2x,d2y,poll[2]+1,poll[3]-1});
						}
					}
				}
			}
		}
	}
}