import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());

		int N, M;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			N = Math.min(N, M-N);
			
			int start = 0;
			int end = M;
			
			long result = 1;
			
			while (start != N) {
				result *= end--;
				result /= ++start;
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}