import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, x, y, reault;
	static List<Integer>[] g;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			T = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			reault = 0;
			g = new List[100];
			v = new boolean[100];
			
			for (int i = 0; i < 100; i++) {
				g[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				g[x].add(y);
			}
			
			bfs(0);
			
			sb.append("#" + T + " " + reault + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void bfs(int current) {
		v[current] = true;
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(current);
		
		while (!q.isEmpty()) {
			int poll = q.poll();
			
			if (poll == 99) {
				reault = 1;
				break;
			}
			
			for (int i : g[poll]) {
				if(v[i]) continue;
				v[i] = true;
				q.offer(i);
			}
		}
	}
}