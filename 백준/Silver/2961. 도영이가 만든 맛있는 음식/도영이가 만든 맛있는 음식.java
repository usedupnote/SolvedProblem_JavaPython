import java.io.*;
import java.util.*;

public class Main {
	static int N, V;
	static int min;
	static int[] sourPoint;
	static int[] bitterPoint;
	
	static void cooking(int cnt, int start, int v, int s, int b) {
		if (cnt != 0) min = Math.min(min, Math.abs(s - b));
		if (cnt == N) return;
		
		for (int i = start; i < N; i++) {
			if ((V&1 << i)!=0) continue;
			cooking(cnt+1, i + 1, v|1<<i, s * sourPoint[i], b + bitterPoint[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		min = 1000000000;
		V = 0;
		sourPoint = new int[N];
		bitterPoint = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sourPoint[i] = Integer.parseInt(st.nextToken());
			bitterPoint[i] = Integer.parseInt(st.nextToken());
		}
		cooking(0, 0, V, 1, 0);
		
		System.out.println(min);
	}
}