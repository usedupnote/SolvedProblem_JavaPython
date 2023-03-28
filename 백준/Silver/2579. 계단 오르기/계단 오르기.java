import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//TestCase 수
		
		int num = 0;
		int[] stair = new int[N+2];
		long[] result = new long[N+2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stair[i] = Integer.parseInt(st.nextToken());
		}
		
		result[0] = stair[0];
		result[1] = stair[0] + stair[1];
		result[2] = stair[2] + (stair[1]>stair[0]?stair[1]:stair[0]);
		
		if (N < 3) System.out.println(result[N-1]);
		else {
			for (int i = 3; i < N; i++) {
				long A = result[i-3] + stair[i-1] + stair[i];
				long B = result[i-2] + stair[i];
				result[i] = (A>B?A:B);
			}
			System.out.println(result[N-1]);
		}
	}
}