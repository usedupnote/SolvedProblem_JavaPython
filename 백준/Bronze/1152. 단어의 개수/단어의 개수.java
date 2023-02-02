import java.io.*;
import java.util.*;

public class Main {		
	static int N;
	
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			st.nextToken();
			N += 1;
		}
		System.out.println(N);
	}
}