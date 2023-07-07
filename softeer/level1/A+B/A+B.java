import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			sb.append("Case #").append(TC).append(": ").append(A+B).append("\n");
		}
		System.out.println(sb);
	}
}