import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int result = 0;
		
		for (int i = 0; i < 5; i++) {
			int N = Integer.parseInt(st.nextToken());
			result += N * N;
		}
		
		sb.append(result % 10);
		
		System.out.println(sb);
		
		br.close();
	}
}