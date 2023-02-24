import java.io.*;
import java.util.*;

public class Main {
	static int N, K, result;
	static int[] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		while (K != 0) {
			result += K / coin[--N];
			K %= coin[N];
		}
		
		System.out.println(result);
	}
}