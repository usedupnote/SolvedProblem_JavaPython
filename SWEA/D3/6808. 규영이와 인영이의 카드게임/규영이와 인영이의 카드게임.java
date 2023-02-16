import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, M, resultp1, resultp2;
	static int[] num;
	static boolean[] v;
	
	static void prem(int cnt, int p1, int p2) {
		if (cnt == 9) {
			if (p1 > p2) resultp1++;
			else if(p1 < p2) resultp2++;
			return;
		}
		
		for (int i = 1; i < 19; i++) {
			if(v[i]) continue;
			v[i] = true;
			if(num[cnt] > i) {
				prem(cnt + 1, p1 + num[cnt] + i, p2);
			} else {
				prem(cnt + 1, p1, p2 + num[cnt] + i);
			}
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			num = new int[9];
			v = new boolean[19];
			resultp1 = 0;
			resultp2 = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				v[num[i]] = true;
			}
			
			prem(0,0,0);
			sb.append("#"+ test_case+ " " + resultp1 + " " + resultp2 + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}