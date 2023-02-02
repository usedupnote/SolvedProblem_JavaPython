import java.io.*;
import java.util.*;

public class Main {		
	static int [] num = new int [42];
	static int result;
	
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[Integer.parseInt(st.nextToken()) % 42] = 1;
		}
		
		for (int i = 0; i < 42; i++) {
			result += num[i];
		}
		
		System.out.println(result);
	}
}