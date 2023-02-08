import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int x1, y1, x2, y2;
	static int check;
	static int[][] num;
		
	public static void main(String[] args) throws IOException {
		// 입출력을 위한 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 자연수 N과 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N + 1][N + 1];
		
		num[0][0] = 0;
		
		for (int cntN = 1; cntN <= N; cntN++) {
			st = new StringTokenizer(br.readLine());
			num[cntN][0] = 0;
			for (int cntN2 = 1; cntN2 <= N; cntN2++) {
				num[cntN][cntN2] = num[cntN][cntN2-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for (int cntM = 0; cntM < M; cntM++) {
			check = 0;
			
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i <= x2; i++) {
				check += num[i][y2] - num[i][y1 -1];
			}
			sb.append(check + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}