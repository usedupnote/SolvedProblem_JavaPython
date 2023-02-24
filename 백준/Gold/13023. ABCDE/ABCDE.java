import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result;
	static StringBuilder sb = new StringBuilder();
	static boolean[] v;
	static ArrayList<Integer>[] al;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			al[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			
			al[from].add(to);
			al[to].add(from);
		}
		
		for (int i = 0; i < N; i++) {
			if (al[i].size() < 1) continue;
			v = new boolean[N];
			// bfs(0);
			dfs(i, 1);
			if(result == 1) break;
		}
		
		System.out.println(result);
	}

	static void dfs(int current, int count) {
		v[current] = true;
		
		if (count == 5) {
			result = 1;
			return;
		}
		
		for (int vertex : al[current]) {
			if(!v[vertex]) {
				v[vertex] = true;
				dfs(vertex, count+1);
				v[vertex] = false;
			}
			if(result == 1) return;
		}
	}
}