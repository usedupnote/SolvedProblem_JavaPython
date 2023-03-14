import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		N = (N / 4) + (N % 4 == 0 ? 0 : 1);
		
		for (int i = 0; i < N; i++) {
			sb.append("long ");
		}
		sb.append("int");
		System.out.println(sb);
	}
}