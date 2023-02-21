import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] pos, base;
	static int[][] map;
	static boolean[] v = new boolean[10];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int [N][10];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		pos = new int[10];
		pos[4] = 1;	// 이미 1번의 자리는 4로 고정
		prem(1);
		System.out.println(result);
	}

	static void prem(int cnt) {
		if(cnt == 4) prem(cnt + 1);
		else {
			if (cnt == 10) {
				game();
				return;
			}
			for (int i = 2; i <= 9; i++) {
				if(v[i]) continue;
				v[i] = true;
				pos[cnt] = i;
				prem(cnt + 1);
				v[i] = false;
			}
		}
	}

	static void game() {
		int count = 0;
		int position = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			base = new int[10];
			
			while (true) {
				position %= 9;
				if(map[i][pos[++position]] == 0) {
					if(++cnt == 3) break;
					continue;
				}
				
				base[position] = map[i][pos[position]];
				for (int d = 1; d <= 9; d++) {
					if(base[d] != 0) {
						if (d != position) base[d] += map[i][pos[position]];
						if(base[d] >= 4) {
							base[d] = 0;
							count++;
						}
					}
				}
			}
		}
		result = Math.max(result, count);
	}
}