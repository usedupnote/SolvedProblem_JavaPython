import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<long[]> q = new PriorityQueue<>(new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0], o2[0]);
			}
		});
		
		long pos, per;
		
		long allPerson = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			pos = Integer.parseInt(st.nextToken());
			per = Integer.parseInt(st.nextToken());
			
			allPerson += per;
			
			q.offer(new long[] {pos, per});
		}
		
		allPerson = (allPerson / 2) + (allPerson%2==1?1:0);
		
		while (!q.isEmpty()) {
			long[] poll = q.poll();
			
			allPerson -= poll[1];
			
			if(allPerson <= 0) {
				System.out.println(poll[0]);
				break;
			}
		}
		br.close();
	}
}