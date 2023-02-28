import java.io.*;
import java.util.*;

public class Main {
	static int[] num;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		num = new int[9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		v = new boolean[9];
		comb(0, 0, 0);
		System.out.println(sb);
	}

	static boolean comb(int cnt, int start, int result) {
		if(cnt == 7) {
			if (result == 100) {
				for (int i = 0; i < 9; i++) {
					if(v[i]) sb.append(num[i] + "\n");
				}
				return true;
			}
			return false;
		}
		for (int i = start; i < 9; i++) {
			if(v[i]) continue;
			v[i] = true;
			if(comb(cnt + 1, start + 1, result + num[i])) return true;
			v[i] = false;
		}
		return false;
	}
}