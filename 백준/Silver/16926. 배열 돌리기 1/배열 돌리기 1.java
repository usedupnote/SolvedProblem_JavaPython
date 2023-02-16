import java.io.*;
import java.util.*;
 
public class Main {
	static final int[] dirX = {0, 1, 0, -1}; // 우 하 좌 상
	static final int[] dirY = {1, 0, -1, 0};
	static int N, M, R;
    static int[][] map;
    
    static void roatate(int cnt) {
    	if (cnt >= Math.min(N, M) / 2) return;
		int saveValue = map[cnt][cnt];

		int dx = cnt;
		int dy = cnt;

		for (int d = 0; d < 4; d++) {
			while (true) {

				dx += dirX[d];
				dy += dirY[d];
				if (dx >= cnt && dx < N - cnt && dy >= cnt && dy < M - cnt) {
					map[dx - dirX[d]][dy - dirY[d]] = map[dx][dy];
				} else {
					dx -= dirX[d];
					dy -= dirY[d];
					break;
				}
			}

		}
		map[cnt + 1][cnt] = saveValue;
		roatate(cnt + 1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
        }
        
        for (int i = 0; i < R; i++) {
        	roatate(0);
		}

        for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]).replace("[", "").replace(",", "").replace("]", ""));
		}
        br.close();
    }
}