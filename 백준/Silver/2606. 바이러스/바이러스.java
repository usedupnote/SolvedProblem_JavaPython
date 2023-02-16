import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result;
	static boolean[][] computer;
	static boolean[] v;
	
	static void visit(int pos) {
		v[pos] = true;
		for (int i = 0; i < N; i++) {
			if (!v[i] && computer[pos][i]) {
				result += 1;
				visit(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		computer = new boolean[N][N];
		v		 = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int pairX = Integer.parseInt(st.nextToken()) - 1;
			int pairY = Integer.parseInt(st.nextToken()) - 1;

			computer[pairX][pairY] = true;
			computer[pairY][pairX] = true;
		}
		
		visit(0);
		
		System.out.println(result);
		br.close();
	}
}