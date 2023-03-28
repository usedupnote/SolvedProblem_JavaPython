import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//TestCase 수
		
		long[] map = new long[n+1];
		map[0] = 1; map[1] = 3;
		long maxv = Long.MAX_VALUE/2;
		
		for (int i = 2; i < n; i++) {
			map[i] = map[i-1] + (2 * map[i-2]);
			if(map[i] > maxv) {
				map[i] %= 10007;
			}
		}
		System.out.println((map[n-1])%10007);
	}
}