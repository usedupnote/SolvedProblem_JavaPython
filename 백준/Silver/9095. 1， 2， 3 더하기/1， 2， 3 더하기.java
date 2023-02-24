import java.io.*;
import java.util.*;

public class Main {
	static int N, K, num;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();

		N = Integer.parseInt(st.nextToken());
		
		result = new int[12];
		
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		
		for (int i = 3; i < 12; i++) {
			result[i] = result[i-1] + result[i-2] + result[i-3];
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			sb.append(result[num] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}