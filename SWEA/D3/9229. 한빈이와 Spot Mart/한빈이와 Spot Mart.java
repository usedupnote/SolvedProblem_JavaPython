import java.io.*;
import java.util.*;

public class Solution {
	static int TC, N, M, result;
	static int[] cookies;
	
	static void compare(int cnt, int start, int weight) {
		if(cnt == 2) {
			if(weight <= M) {
				result = Math.max(result, weight);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			compare(cnt + 1, i + 1, weight + cookies[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		TC = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			cookies = new int[N];
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cookies[i] = Integer.parseInt(st.nextToken());
			}

			compare(0, 0, 0);
			
			if (result == 0) {
				sb.append("#" + test_case + " " + -1 + "\n");
			} else {
				sb.append("#" + test_case + " " + result + "\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}