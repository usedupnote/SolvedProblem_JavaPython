import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		double result = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int compare = Integer.parseInt(st.nextToken());
			result += compare;
			max = Math.max(max, compare);
		}
		
		sb.append(result/(N * max) * 100);
		
		System.out.println(sb);
		
		br.close();
	}
}