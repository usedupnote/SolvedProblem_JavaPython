import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 0; TC < T; TC++) {
			N = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			
			int[] num = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] v = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if (v[i]) continue;
				cnt++;
				int a = i;
				while (!v[a]) {
					v[a] = true;
					a = num[a];
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}