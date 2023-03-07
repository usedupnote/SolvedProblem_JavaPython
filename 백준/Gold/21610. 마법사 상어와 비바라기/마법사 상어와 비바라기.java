import java.io.*;
import java.util.*;

public class Main {
	// 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static final int[] dirX = {0,-1,-1,-1,0,1,1,1};
	static final int[] dirY = {-1,-1,0,1,1,1,0,-1};
	
    static int N, M, C, result;
    static int[][] map;
    static boolean[][] v;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //첫째 줄에 N, M이 주어진다.
        N = Integer.parseInt(st.nextToken());	//2 ≤ N ≤ 50
        M = Integer.parseInt(st.nextToken());	//1 ≤ M ≤ 100

        //0 ≤ A[r][c] ≤ 100
        map = new int[N][N];	
        for (int i = 0; i < N; i++) {
        	//둘째 줄부터 N개의 줄에는 N개의 정수가 주어진다.
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				//r번째 행의 c번째 정수는 A[r][c]를 의미한다.
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        v = new boolean[N][N];

        //비바라기를 시전하면 하늘에 비구름을 만들 수 있다. 
        // 비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다.
        v[N-1][0] = true;
        v[N-1][1] = true;
        v[N-2][0] = true;
        v[N-2][1] = true;
        
        // 이동의 정보
        // 구름에 이동을 M번 명령
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	// i번째 이동 명령은 방향 di과 거리 si로 이루어져 있다.
        	int di = Integer.parseInt(st.nextToken()) - 1;	//1 ≤ di ≤ 8
        	int si = Integer.parseInt(st.nextToken());	//1 ≤ si ≤ 50

        	moveCloud(di, si);
		}

        //M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 출력
        result = 0;
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += map[i][j];
			}
		}
        System.out.println(result);
    }

	private static void moveCloud(int dir, int dist) {
		
		boolean[][] cv = new boolean[N][N];
    	
    	//모든 구름이 di 방향으로 si칸 이동한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j]) continue;
		        // 마법사 상어는 연습을 위해 1번 행과 N번 행을 연결했고, 1번 열과 N번 열도 연결했다. 
				int dx = (i + (dirX[dir] * dist) + N * dist) % N;
				int dy = (j + (dirY[dir] * dist) + N * dist) % N;
				
				cv[dx][dy] = true;
			}
		}

		//구름이 모두 사라진다.
        v = new boolean[N][N];
		
        //각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cv[i][j]) map[i][j] += 1;
			}
		}

		// 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cv[i][j]) {
					for (int d = 1; d < 8; d+=2) {
						int dx = i + dirX[d];
						int dy = j + dirY[d];
						// 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼
						// (r, c)에 있는 바구니의 물이 양이 증가한다.
						//이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
						if(0<=dx && dx<N && 0<=dy && dy<N && map[dx][dy] != 0) {
							map[i][j] += 1;
						}
					}
				}
			}
		}
		// 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
				if(!cv[i][j] && map[i][j] >= 2) {
					map[i][j] -= 2;
					v[i][j] = true;
				}
			}
		}
	}
}