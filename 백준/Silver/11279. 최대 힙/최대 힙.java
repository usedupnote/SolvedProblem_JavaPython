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
				if(o1 > o2) return -1;
				else return 1;
			}
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 0) {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() +"\n");
				}
			}
			else {
				pq.offer(num);
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}