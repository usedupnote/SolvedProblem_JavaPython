import java.io.*;
import java.util.*;

public class Main {
	static int F,S,G,U,D;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//(1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		v = new boolean[F+1];
		int result = bfs();
		System.out.println(result<0?"use the stairs":result);
        br.close();
	}
	private static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {S, 0});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			if (poll[0] == G) return poll[1];
			
			int pollU = poll[0] + U;
			int pollD = poll[0] - D;
			if (pollU <= F && !v[pollU]) {
				q.offer(new int[] {pollU, poll[1] + 1});
				v[pollU] = true;
			}
			if (pollD > 0 && !v[pollD]) {
				q.offer(new int[] {pollD, poll[1] + 1});
				v[pollD] = true;
			}
		}
		return -1;
	}
}