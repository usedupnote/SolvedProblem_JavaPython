import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] pos;
	static int[][] map;
	static boolean[] v = new boolean[10];

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
            if (result - count >= 24 * N) break;
			int cnt = 0;
			boolean[] base = new boolean[4];
			
			while (cnt != 3) {
				position %= 9;
				switch (map[i][pos[++position]]) {
				case 1:
					if (base[3]) {
						base[3] = false;
						count++;
					}
					if (base[2]) {
						base[3] = true;
						base[2] = false;
					}
					if (base[1]) {
						base[2] = true;
						base[1] = false;
					}
					base[1] = true;
					break;
				case 2:
					if (base[3]) {
						base[3] = false;
						count++;
					}
					if (base[2]) {
						base[2] = false;
						count++;
					}
					if (base[1]) {
						base[3] = true;
						base[1] = false;
					}
					base[2] = true;
					break;
				case 3:
					if (base[3]) {
						base[3] = false;
						count++;
					}
					if (base[2]) {
						base[2] = false;
						count++;
					}
					if (base[1]) {
						base[1] = false;
						count++;
					}
					base[3] = true;
					break;
				case 4:
					if (base[3]) {
						base[3] = false;
						count++;
					}
					if (base[2]) {
						base[2] = false;
						count++;
					}
					if (base[1]) {
						base[1] = false;
						count++;
					}
					count++;
					break;

				default:
					cnt++;
					break;
				}
			}
		}
		result = Math.max(result, count);
	}
}