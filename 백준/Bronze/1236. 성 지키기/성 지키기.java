import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] row = new boolean[N];
		boolean[] col = new boolean[M];
		
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (c[j] == 'X') {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		int sumRow = 0;
		for (boolean i : row) {
			if (!i) sumRow++;
		}
		int sumCol = 0;
		for (boolean i : col) {
			if (!i) sumCol++;
		}
		System.out.println(Math.max(sumRow, sumCol));
	}
}