import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] pop;
	static int[][] G;
	static boolean[] set, v;
	static int total = 0;
	static int result = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		pop = new int[N];
		G = new int[N][];
		set = new boolean[N];
		for (int i = 0; i < N; i++) {
			pop[i]= Integer.parseInt(st.nextToken());
			total += pop[i];
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			G[i] = new int[n];
			for (int j = 0; j < n; j++) {
				G[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		subset(0, 0);
		System.out.println(result);
		br.close();
	}
	
	static void subset(int cnt, int sum) {
		if (cnt == N) {
			makeResult(sum);
			return;
		}
		set[cnt] = true;
		subset(cnt+1, sum+pop[cnt]);
		set[cnt] = false;
		subset(cnt+1, sum);
	}

	private static void makeResult(int sum) {
		if (sum == 0 || sum == total) return;
		
		v = new boolean[N];
		int scnt = 0;
		
		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++){
			if (v[i]) continue;
			if (scnt >= 2) return;
			
			scnt++;
			q.add(i);
			
			while (!q.isEmpty()) {
				int n = q.poll();
				if (v[n]) continue;
				v[n] = true;
				for (int g : G[n]) {
					if (v[g]) continue;
					if (set[g] == set[n]) q.add(g);
				}
			}
		}
		int diff = Math.abs(total - 2*sum);
		
		if (result > diff || result < 0) result = diff;
	}
}