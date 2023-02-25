import java.io.*;
import java.util.*;

public class Main {
	static long A, B, result;
	static ArrayDeque<long[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		q = new ArrayDeque<>();
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		result = -1;
		
		bfs();
		
		System.out.println(result);
	}

	static void bfs() {
		q.offer(new long[] {A, 1});
		
		while (!q.isEmpty()) {
			long[] poll = q.poll();
			if (poll[0] == B) {
				result = poll[1];
				return;
			}
			if(B >= poll[0] * 2) {
				q.offer(new long[] {poll[0] * 2, poll[1] + 1});
			}
			if(B >= (poll[0] * 10) + 1) {
				q.offer(new long[] {poll[0] * 10 + 1, poll[1] + 1});
			}
		}
	}
}