import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int i, j;
	static int[] num;
		
	public static void main(String[] args) throws IOException {
		// 입출력을 위한 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 자연수 N과 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		num[0] = 0;
		
		for (int cntN = 1; cntN <= N; cntN++) {
			num[cntN] = num[cntN-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int cntM = 0; cntM < M; cntM++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			sb.append((num[j] - num[i - 1]) + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}