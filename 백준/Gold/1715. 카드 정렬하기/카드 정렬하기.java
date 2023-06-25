import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}
		int result = 0;
		while (q.size() != 1) {
			int p = q.poll();
			p += q.poll();
			
			result += p;
			q.offer(p);
		}
		System.out.println(result);
        br.close();
	}
}