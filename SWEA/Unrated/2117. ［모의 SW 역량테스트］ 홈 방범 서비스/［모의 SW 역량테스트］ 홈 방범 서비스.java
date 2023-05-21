import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			ArrayList<int[]> q = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						q.add(new int[] {i, j});
					}
				}
			}
			int qSize = q.size();
			int maxPrice = qSize * M;
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 1; d <= N*2; d++) {
						int compare = 0;
						// 모든 경우에서 최대 얻을 수 있는 수익보다 운영비용이 클 경우 pass
						if ((d*d)+(((d-1)*(d-1))) > maxPrice) break;
//						System.out.println((d*d)+((d-1)*(d-1)) + " " + maxPrice);
						for (int k = 0; k < qSize; k++) {
							if (d <= Math.abs(q.get(k)[0] - i) + Math.abs(q.get(k)[1] - j)) {
								continue;
							};
							compare++;
						}
						if ((d*d)+((d-1)*(d-1)) > compare * M) continue;
						map[i][j] = Math.max(map[i][j], compare);
						result = Math.max(result, compare);
					}
				}
			}
			sb.append("#").append(TC).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}