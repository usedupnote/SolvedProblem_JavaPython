import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] map = new int[N+1];
		
		map[0] = 3; map[1] = 7;
		
		for (int i = 2; i < N; i++) {
			map[i] = (map[i-1] * 2 + map[i-2]) % 9901;
		}
		System.out.println((map[N-1]) % 9901);
	}
}