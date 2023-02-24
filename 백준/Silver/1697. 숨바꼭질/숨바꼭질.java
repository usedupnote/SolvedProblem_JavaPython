import java.io.*;
import java.util.*;

public class Main {
	static int N, K, result;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q.offer(N);
		
		v = new int[100001];
		
		while (!q.isEmpty()) {
			int poll = q.poll();
			
			if (poll == K) {
				result = v[poll];
				break;
			}
			
			if(poll - 1 >= 0 && v[poll - 1] == 0) {
				v[poll - 1] += v[poll] + 1;
				q.offer(poll - 1);
			}
			if(poll + 1 < 100001 && v[poll + 1] == 0) {
				v[poll + 1] += v[poll] + 1;
				q.offer(poll + 1);
			}
			if(poll * 2 < 100001 && v[poll * 2] == 0) {
				v[poll * 2] += v[poll] + 1;
				q.offer(poll * 2);
			}
		}
		System.out.println(result);
	}
}