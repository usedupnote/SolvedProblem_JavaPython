import java.io.*;
import java.util.*;
 
public class Solution {
	static int T, N, M;
	static int max;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
   
		T = Integer.parseInt(st.nextToken());
		
		for (int test_caes = 1; test_caes <= T; test_caes++) {
			st = new StringTokenizer(br.readLine());
			   
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			max = 0;
			map = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] += map[i][j-1] + map[i-1][j] - map[i-1][j-1];
				}
			}
			
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					max = Math.max(max, map[i][j] - map[i][j-M] - map[i-M][j] + map[i-M][j-M]);
				}
			}
			
			sb.append("#" + test_caes + " " + max + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}