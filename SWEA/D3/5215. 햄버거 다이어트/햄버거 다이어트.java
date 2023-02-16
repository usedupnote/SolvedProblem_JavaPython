import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, maxCalorie, result;
	static ArrayDeque<ArrayDeque<Integer>> computer = new ArrayDeque<>();
	static int[][] menual;
	static boolean[] v;
	
	static void subs(int cnt, int sumSatisfaction, int sumCalorie) {
		if(cnt == N) {
			if (maxCalorie >= sumCalorie) {
				result = Math.max(result, sumSatisfaction);
			}
			return;
		}

		v[cnt] = true;
		subs(cnt+1, sumSatisfaction + menual[cnt][0], sumCalorie + menual[cnt][1]);
		v[cnt] = false;
		subs(cnt+1, sumSatisfaction, sumCalorie);
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			maxCalorie = Integer.parseInt(st.nextToken());
			
			result = 0;
			menual = new int[N][2];
			v = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int ti = Integer.parseInt(st.nextToken());
				int tj = Integer.parseInt(st.nextToken());
				
				menual[i] = new int[] {ti, tj};
			}
			
			subs(0, 0, 0);
			
			sb.append("#" + test_case + " " + result + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}