import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] num;
	static long[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		int max = 5;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, num[i]);
		}

		result = new long[max+1];
		result[0] = 1;
		result[1] = 1;
		result[2] = 1;
		result[3] = 2;
		result[4] = 2;
		
		for (int i = 5; i <= max; i++) {
			result[i] = (result[i-1] + result[i-5]);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(result[num[i] - 1] + "\n");
		}
		
		System.out.println(sb);
	}
}