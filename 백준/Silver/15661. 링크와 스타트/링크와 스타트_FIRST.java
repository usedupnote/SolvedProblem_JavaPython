import java.io.*;
import java.util.*;
 
public class Main {
	static int N, result;
	static int[][] map;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if(i < j) {
					map[i][j] += Integer.parseInt(st.nextToken());
				} else {
					map[j][i] += Integer.parseInt(st.nextToken());
				}
			}
		}
		result = Integer.MAX_VALUE;
		v = new boolean[N];
		subs(0, 0);
		System.out.println(result);
	}

	private static void subs(int cnt, int check) {
		if(cnt == N) {
			if(check == 0 || check == N) return;
			int comp = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if(v[i] && v[j]) {
						comp += (map[i][j]);
					} else if(!v[i] && !v[j]) {
						comp -= (map[i][j]);
					}
				}
			}
			result = Math.min(result, Math.abs(comp));
			return;
		}
		
		v[cnt] = true;
		subs(cnt + 1, check + 1);
		v[cnt] = false;
		subs(cnt + 1, check);
	}
}