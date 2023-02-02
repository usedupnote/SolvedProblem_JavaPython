import java.io.*;
import java.util.*;


public class Main {		
	static int N;
	static int result;
	static int max;
	static String S;
    
	static int [] num = new int[26];
	static char [] ch;
	
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = st.nextToken().toUpperCase();
		
		ch = S.toCharArray();
		
		for (char c : ch) {
			num[c - 65] += 1;
		}
		
		max = Arrays.stream(num).max().getAsInt();
		
		for (int i =0 ; i < 26 ; i++) {
			if (num[i] == max) {
				result = result == 0 ? i + 65 : '?';
			}
		}
		System.out.println(Character.toChars(result));
	}
}