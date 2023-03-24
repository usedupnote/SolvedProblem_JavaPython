import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] v, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
        
		q.offer(N);
		
		v = new int[1000001];
		c = new int[1000001];
		
		
		while (!q.isEmpty()) {
			int poll = q.poll();
			
			if (poll == 1) {
				result = v[poll];
				break;
			}
			
			if(poll % 3 == 0 && v[poll / 3] == 0) {
				c[poll / 3] = poll;
				v[poll / 3] += v[poll] + 1;
				q.offer(poll / 3);
			}
			if(poll % 2 == 0 && v[poll / 2] == 0) {
				c[poll / 2] = poll;
				v[poll / 2] += v[poll] + 1;
				q.offer(poll / 2);
			}
			if(poll - 1 >= 0 && v[poll - 1] == 0) {
				c[poll - 1] = poll;
				v[poll - 1] += v[poll] + 1;
				q.offer(poll - 1);
			}
		}
		
		int now = 1;
		
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		ad.offer(1);
		
		while (c[now] != 0) {
			ad.offer(c[now]);
			now = c[now];
		}
		
		while (!ad.isEmpty()) {
			sb.append(ad.pollLast() + " ");
		}
		
		System.out.println(result);
		System.out.println(sb);
	}
}