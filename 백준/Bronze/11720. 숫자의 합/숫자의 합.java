import java.io.*;
import java.util.*;

public class Main {		
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int result = 0;
		st = new StringTokenizer(br.readLine());
		
		char[] ch = st.nextToken().toCharArray();
		
		for (int i = 0; i < N; i++) {
			result += Character.getNumericValue(ch[i]);
		}
		
		System.out.println(result);
		br.close();
	}
}