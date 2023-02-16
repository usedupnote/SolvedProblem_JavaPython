import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int result, teamA, teamB;
	static int[][] map;
	static boolean[] v;
	
	static void comb(int cnt, int start) {
		if(cnt == N/2) {
			teamA = 0;
			teamB = 0;
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i; j < N; j++) {
					if( v[i] && v[j]) teamA += map[i][j];
					if(!v[i] &&!v[j]) teamB += map[i][j];
				}
			}
			result = Math.min(result, Math.abs(teamA - teamB));
			return;
		}
		
		for (int i = start; i < N ; i++) {
			if(v[i]) continue;
			v[i] = true;
			comb(cnt + 1, i + 1);
			v[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		result = Integer.MAX_VALUE;
		
		v = new boolean[N];
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (i > j) {
					map[j][i] += Integer.parseInt(st.nextToken());
				} else {
					map[i][j] += Integer.parseInt(st.nextToken());
				}
			}
		}
		
		comb(0, 1);
		
		System.out.println(result);
		br.close();
	}
}