import java.io.*;
import java.util.*;
 
public class Main {
    static int[] dirX= {0,1,0,-1};	// 좌 하 우 상
    static int[] dirY= {-1,0,1,0};
    static int[][] pos = {};
    static int N, result;
    
    static int[][] map;
    static boolean[][] v;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //첫째 줄에 격자의 크기 N
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());	//3 ≤ N ≤ 499 (N은 홀수)
        
        // N개의 줄에는 격자의 각 칸에 있는 모래의 양 정보
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		//r번째 줄에서 c번째 주어지는 정수는 A[r][c] 이다.
        		//가운데 칸에 있는 모래의 양은 0
                int c = Integer.parseInt(st.nextToken());	//0 ≤ A[r][c] ≤ 1,000
                map[i][j] = c;
			}
		}
        
        result = 0;
        v = new boolean[N][N];
        
        tornado(N / 2, N / 2, 0);

        //격자의 밖으로 나간 모래의 양을 출력한다.
        System.out.println(result);
    }

	static void tornado(int x, int y, int dir) {
		// 토네이도를 시전하면 격자의 가운데 칸부터 토네이도의 이동이 시작된다.
		int dx = x + dirX[dir];
		int dy = y + dirY[dir];

		v[x][y] = true;
		
		int dust = 0;
		
		int cntX, cntY;
		while (0<=dx && dx<N && 0<=dy && dy<N) {
			dust = 0;
			v[dx][dy] = true;
			
			// 토네이도가 한 칸 이동할 때마다 모래는 다음과 같이 일정한 비율로 흩날리게 된다.
			// 5% 구간
			cntX = dx + dirX[dir] * 2;
			cntY = dy + dirY[dir] * 2;
			if (0<=cntX && cntX<N && 0<=cntY && cntY<N) {
				map[cntX][cntY] += map[dx][dy] / 20;
			} else {
				result += map[dx][dy] / 20;
			}
			dust += map[dx][dy] / 20;

			// 10% 구간
			for (int i = 0; i < 2; i++) {
				cntX = dx + dirX[dir];
				cntY = dy + dirY[dir];
				cntX += dirX[(dir + (1 + (i * 2))) % 4];
				cntY += dirY[(dir + (1 + (i * 2))) % 4];
				if (0<=cntX && cntX<N && 0<=cntY && cntY<N) {
					map[cntX][cntY] += map[dx][dy] / 10;
				} else {
					result += map[dx][dy] / 10;
				}
				dust += map[dx][dy] / 10;
			}

			// 7% 구간
			for (int i = 0; i < 2; i++) {
				cntX = dx + dirX[(dir + (1 + (i * 2))) % 4];
				cntY = dy + dirY[(dir + (1 + (i * 2))) % 4];
				if (0<=cntX && cntX<N && 0<=cntY && cntY<N) {
					map[cntX][cntY] += (map[dx][dy] * 7) / 100;
				} else {
					result += (map[dx][dy] * 7) / 100;
				}
				dust += (map[dx][dy] * 7) / 100;
			}

			// 2% 구간
			for (int i = 0; i < 2; i++) {
				cntX = dx + 2 * dirX[(dir + (1 + (i * 2))) % 4];
				cntY = dy + 2 * dirY[(dir + (1 + (i * 2))) % 4];
				if (0<=cntX && cntX<N && 0<=cntY && cntY<N) {
					map[cntX][cntY] += map[dx][dy] / 50;
				} else {
					result += map[dx][dy] / 50;
				}
				dust += map[dx][dy] / 50;
			}

			// 1% 구간
			for (int i = 0; i < 2; i++) {
				cntX = dx - dirX[dir];
				cntY = dy - dirY[dir];
				cntX += dirX[(dir + (1 + (i * 2))) % 4];
				cntY += dirY[(dir + (1 + (i * 2))) % 4];
				if (0<=cntX && cntX<N && 0<=cntY && cntY<N) {
					map[cntX][cntY] += map[dx][dy] / 100;
				} else {
					result += map[dx][dy] / 100;
				}
				dust += map[dx][dy] / 100;
			}

			// y의 모든 모래가 비율과 α가 적혀있는 칸으로 이동한다. 
			// α로 이동하는 모래의 양은 비율이 적혀있는 
			// 칸으로 이동하지 않은 남은 모래의 양과 같다.
			cntX = dx + dirX[dir];
			cntY = dy + dirY[dir];
			if (0<=cntX && cntX<N && 0<=cntY && cntY<N) {
				// 모래가 이미 있는 칸으로 모래가 이동하면, 모래의 양은 더해진다.
				map[cntX][cntY] += map[dx][dy] - dust;
			} else {
				result += (map[dx][dy] - dust);
			}
			map[dx][dy] = 0;
			
			if(!v[dx + dirX[(dir + 1) % 4]][dy + dirY[(dir + 1) % 4]]) {
				dir = (dir + 1) % 4;
			}
			
			// 토네이도는 한 번에 한 칸 이동한다.
			dx = dx + dirX[dir];
			dy = dy + dirY[dir];
		}		
	}
}