import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		rutStar(1);
		
		System.out.println(sb);
	}

	static void rutStar(int cnt) {
		if (cnt == N) {
			printStar(cnt);
			return;
		}
		printStar(cnt);
		rutStar(cnt+1);
		printStar(cnt);
	}

	private static void printStar(int cnt) {
		for (int i = 0; i < cnt; i++) {
			sb.append("*");
		}
		for (int i = 0; i < (N-cnt) * 2; i++) {
			sb.append(" ");
		}
		for (int i = 0; i < cnt; i++) {
			sb.append("*");
		}
		sb.append("\n");
	}
}