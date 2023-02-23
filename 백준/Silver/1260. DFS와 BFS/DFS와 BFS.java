import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static List<Integer>[] g;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		g = new List[N + 1];
		
		for (int i = 0; i <= N; i++) {
			g[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());

			g[from].add(to);
			g[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(g[i]);
		}
		
		v = new boolean[N + 1];
		dfs(V);
		
		sb.append("\n");
		
		v = new boolean[N + 1];
		bfs(V);
		
		System.out.println(sb);
		br.close();
	}
	
	private static void bfs(int current) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		v[current] = true;
		
		q.add(current);
		sb.append(current + " ");
		
		while (!q.isEmpty()) {
			int poll = q.poll();
			
			for (int i : g[poll]) {
				if(v[i]) continue;
				v[i] = true;
				sb.append(i + " ");
				q.offer(i);
			}
			
		}
	}

	private static void dfs(int current) {
		v[current] = true;
		sb.append(current + " ");
		
		for (int i : g[current]) {
			if(!v[i]) {
				dfs(i);
			}
		}
	}
}