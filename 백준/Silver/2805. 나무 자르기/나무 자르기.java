import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		long min = Integer.MAX_VALUE;
		long max = 0;
		
		long[] trees = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			min = 0;
			max = Math.max(max, trees[i]);
		}
		
		while (min <= max) {
			long mid = (min + max) / 2;
			long check = M;
			
			for (long i : trees) {
				if (i > mid) {
					check -= (i - mid);
				}
			}
			
			if (check > 0) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(max);
		br.close();
	}
}