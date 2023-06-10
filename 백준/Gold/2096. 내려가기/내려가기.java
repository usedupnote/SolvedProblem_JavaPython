import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] max = new int[N][3];
		max[0] = map[0].clone();
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = j-1; k <= j+1; k++) {
					if (0>k || k>=3) continue;
					max[i][j] = Math.max(max[i][j], map[i][j] + max[i-1][k]);
				}
			}
		}

		int[][] min = new int[N][3];

		min[0] = map[0].clone();
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				min[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = j-1; k <= j+1; k++) {
					if (0>k || k>=3) continue;
					min[i][j] = Math.min(min[i][j], map[i][j] + min[i-1][k]);
				}
			}
		}
		int maxV = 0;
		int minV = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			maxV = Math.max(max[N-1][i], maxV);
			minV = Math.min(min[N-1][i], minV);
		}
		
		System.out.println(maxV + " " + minV);
	}
}