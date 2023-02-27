import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int[] group;
	static boolean[] v;
	
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

		//창용 마을에 사는 사람의 수(N)와 서로를 알고 있는 사람의 관계 수(M) (1 ≤ N ≤ 100, 0 ≤ M ≤ N(N-1)/2) 이 공백 하나로 구분되어 주어진다.

			st = new StringTokenizer(br.readLine());	
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			group = new int[N];
			
			make();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());	
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				
				union(a,b);
			}
			//이후 M개의 줄에 걸쳐서 서로를 알고 있는 두 사람의 번호가 주어진다.
			
			int result = 0;
			v = new boolean[N];
			for (int i : group) {
				if(v[find(i)]) continue;
				v[find(i)] = true;
				result++;
			}
			sb.append("#"+test_case+" " + result+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}