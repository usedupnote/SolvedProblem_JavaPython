import java.io.*;
import java.util.*;

public class Main {		
	static int N;
	static int[][] map;
	static int[][] mapWidth;
	static int[][] mapDiagonal;
	static int[][] mapLength;
	
	static void canReach(int i, int j) {
		if (i == 0) {
			mapWidth[i][j] += mapWidth[i][j-1];
		}
		else {
			if (map[i][j-1] == 0) {
				mapWidth[i][j] += mapWidth[i][j-1] + mapDiagonal[i][j-1];
			}
			if (map[i-1][j] == 0) {
				mapLength[i][j] += mapLength[i-1][j] + mapDiagonal[i-1][j];
			}
			if (map[i-1][j-1] == 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {
				mapDiagonal[i][j] += mapWidth[i-1][j-1] + mapLength[i-1][j-1] + mapDiagonal[i-1][j-1];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		mapWidth = new int[N][N];
		mapDiagonal = new int[N][N];
		mapLength = new int[N][N];
		
		mapWidth[0][1] = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (map[N-1][N-1] == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (map[i][j] == 0) {
						canReach(i, j);
					}
				}
			}
			System.out.println(mapLength[N-1][N-1] + mapDiagonal[N-1][N-1] + mapWidth[N-1][N-1]);
		}
		else {
			System.out.println(0);
		}
	}
}