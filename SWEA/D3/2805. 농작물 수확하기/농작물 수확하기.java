import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N;
	static int corp;
	static int f, l;
	static int result;
	static char[] ch;
	
	public static void main(String[] args) throws IOException {
		// 입출력을 위한 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// test_case 갯수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			f = (N + 1)/ 2 - 1;
			l = (N + 1)/ 2 - 1;
			ch = new char[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ch = st.nextToken().toCharArray();
				
				for (int j = 0; j < N; j++) {
					corp = Character.valueOf(ch[j]) - '0';
					
					if(f >= j && l <= j) {
						result += corp;
					}
				}
				if (i < (N + 1)/ 2 - 1) {
					f++;
					l--;
				} else {
					f--;
					l++;
				}
			}
			
			sb.append("#" + test_case + " "+result + "\n");
		}
		System.out.println(sb.toString());
	}
}