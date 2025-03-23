import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			char[] c = s.toCharArray();
			
			for (int j = 0; j < m; j++) {
				if (c[j] == '1') map[i][j] = (i == 0 || j == 0 ? 1 : Integer.min(map[i-1][j-1], Integer.min(map[i-1][j], map[i][j-1])) + 1);
				result = Integer.max(result, map[i][j]);
			}
		}
		
		System.out.println(result * result);
		br.close();
	}
}