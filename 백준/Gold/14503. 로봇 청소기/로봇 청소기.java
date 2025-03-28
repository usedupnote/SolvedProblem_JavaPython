import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1, 0, 1, 0};	// 상 우 하 좌
	static final int[] dirY = {0, 1, 0, -1};
	static int N, M, result;
	static int[][] map;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //방의 크기 N,M
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());	// 3 <= N, M <= 50
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        //처음에 로봇 청소기가 있는 칸의 좌표 (r, c)와 처음에 로봇 청소기가 바라보는 방향 d가 입력
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        //N개의 줄에 M개씩 입력된다. 
        // 0인 경우 (i, j) 청소되지 않은 빈 칸
        // 1인 경우 (i, j) 벽
        // 방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽이 있다.
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        robote(r, c, d);
		
		//로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수를 출력한다.
        System.out.println(result);
	}

	private static void robote(int x, int y, int d) {
        //로봇 청소기는 다음과 같이 작동한다.
		
		while (true) {			
			//현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(map[x][y] == 0) {
				result++;
				map[x][y] = 2;
			}
			
			boolean check = false;
			
			for (int i = 0; i < 4; i++) {
				if(map[x + dirX[i]][y +dirY[i]] == 0) {
					check = true;
					break;
				}
			}
			
			if (check) {		//현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
				//반시계 방향으로 90도 회전한다.
				d = (d + 3) % 4;
				
				//바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				int dx = x + dirX[d];
				int dy = y + dirY[d];
				
				if(map[dx][dy] == 0) {
					x = dx;
					y = dy;
				}
				
			} else {			//현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
				//바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로
				x -= dirX[d];
				y -= dirY[d];
				
				if(map[x][y] == 1) {
					//바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
					break;
				}
			}
		}
	}
}