import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		long num[] = new long[N+1];
		
		num[0] = 0;
		num[1] = 1;
		
		if(N > 1) {
			for (int i = 2; i <= N; i++) {
				num[i] = num[i-1] + num[i-2];
			}
		}
		sb.append(num[N]);
		
		System.out.println(sb);
		br.close();
	}
}