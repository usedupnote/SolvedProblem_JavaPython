import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static PriorityQueue<Integer> coin;
	static long[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());	// n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000)
		k = Integer.parseInt(st.nextToken());
		
		coin = new PriorityQueue<>();
		
		// 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			if (value > k) continue;
			coin.offer(value);
		}
		
		//각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
		result = new long[k+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[0] = 0;
		
		int size = coin.size();
		
		for (int i = 0; i < size; i++) {
			int poll = coin.poll();
			for (int j = poll; j <= k; j++) {
				result[j] = Math.min(result[j], result[j - poll] + 1);
			}
		}
		System.out.println(result[k]==Integer.MAX_VALUE?-1:result[k]);
	}
}