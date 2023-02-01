import java.io.*;
import java.util.*;

public class Main {		
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		
		int[] S = new int[L];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < L; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int min = 0;
		int max = 1000;
		
		for (int i : S) {
			if (n == i) {
				min = n;
				max = n;
				break;
			}
			if (n > i) {
				min = Math.max(min, i);
			}
			if (n < i) {
				max = Math.min(max, i);
			}
		}
		
		if (max - min < 2) {
			System.out.println(0);
		} else {
			max = max - n - 1;
			min = n - min - 1;
			System.out.println((max * min) + max + min);
		}
		
		br.close();
	}
}