import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int result = 1;
			int a,c,d;
			char b;
			
			ArrayDeque<int[]> tree = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				a = Integer.parseInt(st.nextToken());
				b = st.nextToken().toCharArray()[0];
				
				if (0 <= b - '0' && b - '0' < 10) {
					if(st.hasMoreTokens()) {
						result = 0;
					}
				} else {
					if(!st.hasMoreTokens()) {
						result = 0;
					}
				}
			}
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}