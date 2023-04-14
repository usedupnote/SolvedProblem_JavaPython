import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static final long MAV = 999_999_999;
	static long[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//집의 수 N(2 ≤ N ≤ 1,000)
		
		long result = MAV;
		map = new long[N][3];
		
		for (int i = 0; i < N; i++) {
			//집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 3; i++) {
			long[][] compareMap = new long[N+1][3];
			
			for (int j = 0; j < N; j++) {
				Arrays.fill(compareMap[j], MAV);
			}
			
			compareMap[0][i] = map[0][i];
			
			for (int j = 1; j < N-1; j++) {
				for (int d = 0; d < 3; d++) {
					compareMap[j][d] = Math.min(compareMap[j][d], Math.min(compareMap[j-1][(d+1)%3], compareMap[j-1][(d+2)%3]) + map[j][d]);
				}
			}
			compareMap[N-1][(i+1)%3] = Math.min(compareMap[N-1][(i+1)%3], Math.min(compareMap[N-2][i%3], compareMap[N-2][(i+2) % 3]) + map[N-1][(i+1)%3]);
			compareMap[N-1][(i+2)%3] = Math.min(compareMap[N-1][(i+2)%3], Math.min(compareMap[N-2][i%3], compareMap[N-2][(i+1) % 3]) + map[N-1][(i+2)%3]);
			result = Math.min(result, Math.min(compareMap[N-1][(i+1)%3], compareMap[N-1][(i+2)%3]));
		}
		System.out.println(result);
	}
}