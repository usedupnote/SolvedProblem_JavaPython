import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> q = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				q.add(Long.parseLong(st.nextToken()));
			}
			
			long result = 0;
			while (q.size() != 1) {
				long cur = q.poll() + q.poll();
				q.add(cur);
				result += cur;
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
        br.close();
    }
}