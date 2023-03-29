import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] v;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			v = new int[N];
			v[i] = 2;
			dfs(i,1,0);
		}
		
		System.out.println(result);
		br.close();
	}

	private static void dfs(int current, int cnt, int price) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				if(v[i] == 2) {
					if(map[current][i] != 0) {
						result = Math.min(result, price + map[current][i]);
					}
					return;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if(v[i] != 0 || map[current][i] == 0) continue;
			v[i] = 1;
			dfs(i, cnt+1, price + map[current][i]);
			v[i] = 0;
		}
	}
}