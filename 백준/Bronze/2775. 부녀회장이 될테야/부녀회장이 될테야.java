import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		long[][] apat = new long[15][15];
		
		for (int i = 0; i < 15; i++) {
			apat[0][i] = i + 1;
		}
		
		for (int i = 1; i < 15; i++) {
			apat[i][0] = apat[i-1][0];
			for (int j = 1; j < 15; j++) {
				apat[i][j] = apat[i][j-1] + apat[i-1][j];
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			sb.append(apat[k][n-1] + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
