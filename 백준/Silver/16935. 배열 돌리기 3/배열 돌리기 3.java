import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {0, 1, 1}; // 우 대각 하
	static int[] dirY = {1, 1, 0};
	static int N, M, R;
	static int[] cal;
	static int[][] map;
	
	static void cal(int check) {
		switch (check) {
		case 1:
			cal1();
			break;
		case 2:
			cal2();
			break;
		case 3:
			cal3();
			break;
		case 4:
			cal4();
			break;
		case 5:
			cal5();
			break;
		default:
			cal6();
			break;
		}
	}

	static void cal1() {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] += map[N - i - 1][j];
				map[N - i - 1][j] = map[i][j] - map[N - i - 1][j];
				map[i][j] -= map[N - i - 1][j];
			}
		}
	}
	static void cal2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				map[i][j] += map[i][M - j - 1];
				map[i][M - j - 1] = map[i][j] - map[i][M - j - 1];
				map[i][j] -= map[i][M - j - 1];
			}
		}
	}
	static void cal3() {
		int[][] compareMap = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				compareMap[j][i] = map[N - i- 1][j];
			}
		}
		map = new int[M][N];
		M += N;
		N = M - N;
		M -= N;
		map = compareMap;
	}
	static void cal4() {
		int[][] compareMap = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				compareMap[M-j-1][i] = map[i][j];
			}
		}
		map = new int[M][N];
		M += N;
		N = M - N;
		M -= N;
		map = compareMap;
	}
	
	static void cal5() {
		for (int d = 0; d < 3; d++) {
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					int di = i + (N/2 * dirX[d]);
					int dj = j + (M/2 * dirY[d]);
					
					map[i][j] += map[di][dj];
					map[di][dj] = map[i][j] - map[di][dj];
					map[i][j] -= map[di][dj];
				}
			}
		}
	}
	
	static void cal6() {
		for (int d = 2; d >= 0 ; d--) {
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					int di = i + (N/2 * dirX[d]);
					int dj = j + (M/2 * dirY[d]);
					
					map[i][j] += map[di][dj];
					map[di][dj] = map[i][j] - map[di][dj];
					map[i][j] -= map[di][dj];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		cal = new int[R];
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			cal(Integer.parseInt(st.nextToken()));
		}

		for (int j = 0; j < N; j++) {
			sb.append(Arrays.toString(map[j]).replace("[", "").replace(",", "").replace("]", "") + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}