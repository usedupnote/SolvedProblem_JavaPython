import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			q.offer(new int[] {start, end});
		}
		int current = 0;
		int result = 0;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			if (poll[1] < current) continue;
            
			int left = poll[1] - Math.max(current, poll[0]);
			int cnt = (left / L) + (left % L==0?0:1);
			result += cnt;
			current = (cnt * L) + Math.max(current, poll[0]);
		}
		System.out.println(result);
	}
}