import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			q.offer(Integer.parseInt(st.nextToken()));
		}
		int maxWeight = 0;
		while (!q.isEmpty()) {
			maxWeight = Math.max(maxWeight, q.size() * q.peek());
			q.poll();
		}
		System.out.println(maxWeight);
	}
}