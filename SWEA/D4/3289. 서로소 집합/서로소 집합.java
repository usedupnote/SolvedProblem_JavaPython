import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	
	static int[] group;
	
	static void make() {
		for (int i = 0; i < N; i++) group[i] = i;
	}
	static int find(int a) {
		if(group[a] == a) return a;
		return group[a] = find(group[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		group[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb   = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());	

		// 테스트 케이스의 수 T가 주어진다.
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case+" ");
			
			st = new StringTokenizer(br.readLine());	

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			group = new int[N + 1];
			
			for (int i = 0; i <= N; i++) {
				group[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(s == 0) {
                    union(b, a);
				} else {
					sb.append(find(a) == find(b)?1:0);
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}