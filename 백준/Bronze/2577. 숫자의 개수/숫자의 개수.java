import java.io.*;
import java.util.*;

public class Main {		
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int [] result = new int[10];
		
		int num = 1;
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num *= Integer.parseInt(st.nextToken());
		}
		
		char[] ch = String.valueOf(num).toCharArray();
		
		for (char i : ch) {
			result[Character.getNumericValue(i)] += 1;
		}
		
		System.out.println(Arrays.toString(result).replace("[", "").replace("]", "").replace(", ", "\n"));
		br.close();
	}
}