import java.io.*;
import java.util.*;

public class Main {
	static int M;
	static int N;
	static int K;
	static int[][] cabadge;
	
	// 상 우 하 좌
	static int[] dirX = {1, 0, -1, 0};
	static int[] dirY = {0, 1, 0, -1};
	
	static void search(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int di = i + dirX[d];
			int dj = j + dirY[d];
			
			if (di >= 0 && di < M && dj >= 0 && dj < N ) {
				if(cabadge[di][dj] == 1) {
					cabadge[di][dj] = 0;
					search(di, dj);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T ; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			M =	Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int result = 0;
			
			cabadge = new int[M][N];
			
			for (int i = 0; i < K; i++) {
				StringTokenizer pos = new StringTokenizer(br.readLine(), " ");
				
				int posX = Integer.parseInt(pos.nextToken());
				int posY = Integer.parseInt(pos.nextToken());
				
				cabadge[posX][posY] = 1;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(cabadge[i][j] == 1) {
						cabadge[i][j] = 0;
						search(i, j);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}