import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, X;
	static int[] A;
	static int result;
	
	static void Comb(int cur, int cnt, int total, int big, int small) {
		if(cnt >= 2 && big != Integer.MIN_VALUE && small != Integer.MAX_VALUE && (big - small) >= X && total >= L && total <= R) {
			result++;
		}

		for (int i = cur+1; i < N; i++) {
			Comb(i, cnt+1, total+A[i], Integer.max(big, A[i]), Integer.min(small, A[i]));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		result = 0;
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		Comb(-1, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println(result);
		br.close();
	}
}