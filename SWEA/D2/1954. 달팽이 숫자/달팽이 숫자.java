import java.io.*;
import java.util.*;
 
public class Solution {
	static int T, N, d;
	static int count;
	static int posX, posY;
	static int[] dirX = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dirY = {1, 0, -1, 0};
	static int[][] map;
	
	static void snail(int n) {
		if(n == 1) {
			map[posX][posY] = ++count;
			return;
		} else if (n < 1) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < n; j++) {
				map[posX][posY] = ++count;
				posX += dirX[i];
				posY += dirY[i];
			}
		}
		
		posX += 1;
		posY += 1;
		
		snail(n - 2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
   
		T = Integer.parseInt(st.nextToken());
   
		for (int test_case = 1; test_case <= T; test_case++) {
			posX = 0;
			posY = 0;
			count = 0;
			d = 0;
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			snail(N);
			
			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N; i++) {
				sb.append(Arrays.toString(map[i]).replace("[", "").replace(",", "").replace("]", "")).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}