import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) > Math.abs(o2)) {
					return 1;
				} else if(Math.abs(o1) < Math.abs(o2)) {
					return -1;
				} else {
					return o1 - o2;
				}
			}
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num =Integer.parseInt(st.nextToken());
			if(num != 0) pq.offer(num);
			else {
				if (!pq.isEmpty()) {
					sb.append(pq.poll() + "\n");
				} else {
					sb.append("0\n");
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}