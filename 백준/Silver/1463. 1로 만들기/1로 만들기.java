import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> q = new ArrayDeque<>();

		int result = 0;
		q.offer(N);
		
		int[] v = new int[N+2];
		
		while (!q.isEmpty()) {
			int poll = q.poll();
			if (poll == 1) result = v[poll];
			
			if(poll % 3 == 0 && v[poll / 3] == 0) {
				v[poll / 3] += v[poll] + 1;
				q.offer(poll / 3);
			}
			if(poll % 2 == 0 && v[poll / 2] == 0) {
				v[poll / 2] += v[poll] + 1;
				q.offer(poll / 2);
			}
			if(poll - 1 >= 0 && v[poll - 1] == 0) {
				v[poll - 1] += v[poll] + 1;
				q.offer(poll - 1);
			}
		}
		System.out.println(result);
	}
}