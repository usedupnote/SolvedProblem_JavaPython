import java.io.*;
import java.util.*;

public class Main {
	static int N, M, team1, team2;
	static int[] num, v;
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		num = new int[9];
		v = new int[7];
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			num[i]  = Integer.parseInt(st.nextToken());
		}
		comb(0,0,0);
		System.out.println(sb);
		br.close();
	}
	
	static boolean comb(int cnt, int start, int point) { 
		if (cnt == 7) {
			if(point == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(v[i]);
				}
				return true;
			}
			return false;
		}
		
		for (int i = start; i < 9; i++) {
			v[cnt] = num[i];
			if (comb(cnt + 1, i+1, point + num[i])) {
				return true;
			}
		}
		return false;
	}
}