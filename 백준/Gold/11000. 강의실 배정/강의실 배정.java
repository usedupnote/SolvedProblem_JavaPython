import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int result = 0;
		
		PriorityQueue<long[]> q1 = new PriorityQueue<>(new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0]) {
					return Long.compare(o1[1], o2[1]);
				}
				return Long.compare(o1[0], o2[0]);
			}
		});
		
		PriorityQueue<long[]> q2 = new PriorityQueue<>(new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[1], o2[1]);
			}
		});
		
		long x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken()); 
			y = Long.parseLong(st.nextToken()); 
			q1.offer(new long[] {x, y});
		}
		
		while (!q1.isEmpty()) {
			long[] poll = q1.poll();
			
			while (q2.size() > 0 && q2.peek()[1] <= poll[0]) {	// 더 빠르면 빠지기
				q2.poll();
			}
			q2.offer(poll);
			result = Math.max(result, q2.size());
		}
		result = Math.max(result, q2.size());
		
		System.out.println(result);
		br.close();
	}
}