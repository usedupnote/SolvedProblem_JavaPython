import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		result = new int[N+1];
		result[0] = 1;
		result[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			result[i] = (result[i-1] + result[i-2])%10007;
		}
		
		System.out.println(result[N]);
	}
}