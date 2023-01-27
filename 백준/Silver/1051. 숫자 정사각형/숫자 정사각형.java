import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M =	Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long result = 0;
		int check = 1;
		
		int[][] map = new int[M][N];
				
		for (int i = 0; i < M; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(ch[j]);
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				check = 1;
				
				while (true) {
					int di = i + check;
					int dj = j + check;
					
					if(di >= 0 && di < M && dj >= 0 && dj < N) {
						if (map[i][j] == map[i][dj] && map[i][j] == map[di][j]  && map[i][j] == map[di][dj]) {
							result = Math.max(check, result);
						}
					} else {
						break;
					}
					check++;
				}
			}
		}
		result = (long)Math.pow(result + 1, 2);
		sb.append(result);
		System.out.println(sb);
		br.close();
	}
}