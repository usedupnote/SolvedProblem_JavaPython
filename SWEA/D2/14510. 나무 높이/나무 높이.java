import java.io.*;
import java.util.*;
 
public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// 나무의 개수 N
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			// 나무들의 높이가 N개의 자연수			
			int[] trees = new int[N];
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(max < trees[i]) max = trees[i];
			}
			
			int even = 0;
			int odd = 0;
			
			for (int i = 0; i < N; i++) {
				int now = max - trees[i];
				even += now / 2;
				odd += now % 2;
			}
			int result = 0;
			
			if(odd > even) {
				result = (odd * 2) - 1;
			} else {
				result = (odd * 2) + ((((even - odd) * 2) / 3) * 2) + (((even - odd) * 2) % 3);
			}
			sb.append("#"+ test_case + " " + result + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}