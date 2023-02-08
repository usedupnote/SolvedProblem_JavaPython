import java.io.*;
import java.util.*;
 
public class Solution {
	static int T, N, d;
	static int count;
	static int posX, posY;
	static int[] dirX = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dirY = {1, 0, -1, 0};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
   
		T = Integer.parseInt(st.nextToken());
   
		for (int test_case = 1; test_case <= T; test_case++) {
			posX = 0;
			posY = -1;
			count = 1;
			d = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			while (count <= N * N) {
				int dx = posX + dirX[d];
				int dy = posY + dirY[d];
				
				if (!(dx >= 0 && dx < N && dy >= 0 && dy < N)) {
					d = (d + 1) % 4;
				} else if (map[dx][dy] != 0) {
					d = (d + 1) % 4;
				}
				
				posX += dirX[d];
				posY += dirY[d];
				
				map[posX][posY] = count++;
			} 
			
			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N; i++) {
				sb.append(Arrays.toString(map[i]).replace("[", "").replace(",", "").replace("]", "")).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}